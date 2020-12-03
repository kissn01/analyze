package com.yoooum.service;

import com.yoooum.dao.PlannDao;
import com.yoooum.dao.UserBehaviorDao;
import com.yoooum.domain.*;
import com.yoooum.util.DateUtil;
import com.yoooum.util.ReadExcel;
import com.yoooum.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.unit.DataUnit;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/25 21:22
 * @描述:
 */
@Service
public class UserBehaviorService {
    @Autowired
    private UserBehaviorDao userBehaviorDao;

    @Autowired
    private PlannDao plannDao;

    /**
     * 玩家游戏时长分布
     *
     * @param searchDate
     * @param platformId
     * @return
     */
    public List<GameTimeSection> queryGameTime(String searchDate, Integer platformId, Integer checkId) {
        List<String> betweenDate = DateUtil.getLastSevenDay(0, 7);
        List<GameTimeSection> gameTimeSections = new ArrayList<GameTimeSection>();

        //默认查询最近7天
        if (searchDate != null) {
            String begTime = (String) searchDate.subSequence(0, 10);
            String endTime = (String) searchDate.subSequence(13, 23);
            betweenDate = DateUtil.getBetweenDate(begTime, endTime);
            //倒叙日期
            Collections.reverse(betweenDate);
        }

        for (int i = 0; i < betweenDate.size(); i++) {
            String tbName = "eventlogout_" + betweenDate.get(i).replace("-", "");
            String begDay = betweenDate.get(i) + " 0:00:00";
            String endDay = betweenDate.get(i) + " 23:59:59";
            GameTimeSection gameTimeSection = userBehaviorDao.queryGameTime(tbName, DateUtil.strToStamp(begDay), DateUtil.strToStamp(endDay), platformId, checkId);
            gameTimeSection.setMyDate(betweenDate.get(i));

            gameTimeSections.add(gameTimeSection);
        }

        return gameTimeSections;
    }


    /**
     * 指定玩家信息查询
     *
     * @param searchDate
     * @param uin
     * @param osType
     * @param zoneId
     * @return
     */
    public UserInfo queryUserInfo(String searchDate, Integer uin, Integer osType, Integer zoneId) {
        UserInfo userInfo = new UserInfo();
        if (uin != null && osType != null && zoneId != null) {
            String myDate = DateUtil.getPastDate(0);
            String begDay = myDate + " 0:00:00";
            //默认查询当天
            if (searchDate != null) {
                begDay = searchDate.subSequence(0, 10) + " 0:00:00";
            }
            try {
                System.out.println(begDay);
                //查询当日最大关卡
                UserInfo userTemp = userBehaviorDao.queryMaxLev(("eventclearaward_" + begDay.subSequence(0, 10)).replace("-", ""), uin, osType, zoneId);
                System.out.println(userTemp);
                //查询当日体力消耗
                Integer manual = userBehaviorDao.queryManual(("eventitemflow_" + begDay.subSequence(0, 10)).replace("-", ""), uin, osType, zoneId);
                System.out.println(manual);
                //查询当天的充值金额e
                Integer charge = userBehaviorDao.queryCharge(("eventcharge_" + begDay.subSequence(0, 10)).replace("-", ""), uin, osType, zoneId);
                System.out.println(charge);
                //查询当天的在线时长和当日最终等级
                UserInfo user = userBehaviorDao.queryOnlineTime(("eventlogout_" + begDay.subSequence(0, 10)).replace("-", ""), uin, osType, zoneId);
                System.out.println(userTemp + "||" + manual + "||" + charge + "||" + user);

                //设值
                userInfo.setMaxPlann(userTemp.getMaxPlann());
                userInfo.setManual(manual);
                userInfo.setMoney(charge);
                userInfo.setUserLvl(user.getUserLvl());
                userInfo.setOnlineTime(DateUtil.secToTime(Integer.parseInt(user.getOnlineTime())));
                System.out.println(123);
            } catch (Exception e) {
                System.out.println("SQL查询异常！" + e.getMessage());
            }

        }


        return userInfo;
    }


    /**
     * 玩家英雄出战统计
     *
     * @param searchDate
     * @param platformId
     * @param checkId
     * @return
     */
    public Map<String, List> queryFightHero(String searchDate, Integer platformId, Integer checkId) {
        //格式化英雄名称
        Map<String, String> nameMap = ReadExcel.readXlsmToMap("config/Character.xlsm", "Character_Char", 9, 1, 2);
        //计算时 保留2位小数
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        Map<String, List> map = new HashMap<>();

        //默认·查询当天
        String begDay = DateUtil.getPastDate(0) + " 0:00:00";
        String endDay = DateUtil.getPastDate(0) + " 23:59:59";
        if (searchDate != null) {
            begDay = searchDate.subSequence(0, 10) + " 0:00:00";
            endDay = searchDate.subSequence(13, 23) + " 23:59:59";
        }
        String tbName = ("eventclearaward_" + begDay.subSequence(0, 10)).replace("-", "");
        //1.查询hero出战总次数
        FightHero fightHero = userBehaviorDao.queryFightSum(tbName, DateUtil.strToStamp(begDay), DateUtil.strToStamp(endDay), platformId, checkId);
        //2.查询每个英雄出战总次数
        List<FightHero> fightHeroes = userBehaviorDao.queryFightHero(tbName, DateUtil.strToStamp(begDay), DateUtil.strToStamp(endDay), platformId, checkId);
        //3.构造表头
        List<String> nameList = new ArrayList<>();
        nameList.add("日期");
        nameList.add("DAU");
        nameList.add("总出战次数");
        for (int i = 0; i < fightHeroes.size(); i++) {
            nameList.add(nameMap.get(String.valueOf(fightHeroes.get(i).getRoleId())) + "出战次数");
            nameList.add(nameMap.get(String.valueOf(fightHeroes.get(i).getRoleId())) + "出战率");
        }
        //4.构造值
        List<Object> valueList = new ArrayList<>();
        valueList.add(begDay.subSequence(0, 10));
        valueList.add(fightHero.getRoleId());
        valueList.add(fightHero.getFightNum());
        for (int i = 0; i < fightHeroes.size(); i++) {
            valueList.add(fightHeroes.get(i).getFightNum());
            if (fightHero.getFightNum() != 0) {

                valueList.add(decimalFormat.format(fightHeroes.get(i).getFightNum() * 100.00 / fightHero.getFightNum()) + "%");
            } else {
                valueList.add(0.00);
            }

        }
        //5.存入map 返回
        map.put("nameList", nameList);
        map.put("valueList", valueList);


        return map;
    }


    /**
     * 英雄关卡出战情况
     *
     * @param searchDate
     * @param platformId
     * @param chapterId
     * @return
     */
    public Map<String, List> queryPlannHero(String searchDate, Integer platformId, Integer chapterId, Integer checkId) {
        //格式化英雄名称
        Map<String, String> nameMap = ReadExcel.readXlsmToMap("config/Character.xlsm", "Character_Char", 9, 1, 2);
        //计算时 保留2位小数
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        Map<String, List> map = new HashMap<>();

        //默认选择第一章
        if (null == chapterId) {
            chapterId = 1;
        }
        //获取开始和结束章节id
        Map<String, Integer> chapter = UserUtil.getChapter(chapterId);
        Integer begChapterId = chapter.get("begChapterId");
        Integer endChapterId = chapter.get("endChapterId");

        //默认·查询当天
        String begDay = DateUtil.getPastDate(0) + " 0:00:00";
        String endDay = DateUtil.getPastDate(0) + " 23:59:59";

        if (searchDate != null) {
            begDay = searchDate.subSequence(0, 10) + " 0:00:00";
            endDay = searchDate.subSequence(13, 23) + " 23:59:59";
        }
        String tbName = ("eventclearaward_" + begDay.subSequence(0, 10)).replace("-", "");
        //1.查询查询每个英雄出战次数
        List<FightHero> fightHeroes = userBehaviorDao.queryPlannHero(tbName, DateUtil.strToStamp(begDay), DateUtil.strToStamp(endDay), platformId, begChapterId, endChapterId, checkId);
        //3.构造表头
        List<String> nameList = new ArrayList<>();
        nameList.add("日期");
        nameList.add("开启总次数");
        //开启总次数
        Integer openSum = 0;
        for (int i = 0; i < fightHeroes.size(); i++) {
            nameList.add(nameMap.get(String.valueOf(fightHeroes.get(i).getRoleId())) + "开启次数");
            nameList.add(nameMap.get(String.valueOf(fightHeroes.get(i).getRoleId())) + "开启率");
            openSum += fightHeroes.get(i).getFightNum();
        }
        //4.构造值
        List<Object> valueList = new ArrayList<>();
        valueList.add(begDay.subSequence(0, 10));
        valueList.add(openSum);
        for (int i = 0; i < fightHeroes.size(); i++) {
            valueList.add(fightHeroes.get(i).getFightNum());
            if (openSum != 0) {
                valueList.add(decimalFormat.format(fightHeroes.get(i).getFightNum() * 100.00 / openSum) + "%");
            } else {
                valueList.add(0.00);
            }

        }
        //5.存入map 返回
        map.put("nameList", nameList);
        map.put("valueList", valueList);

        return map;
    }


    /**
     * 玩家等级分布
     *
     * @param searchDate
     * @param platformId
     * @param checkId
     * @return
     */
    public List<UserLevel> queryUserLevel(String searchDate, Integer platformId, Integer checkId) {
        //默认查询当天
        String pastDate = DateUtil.getPastDate(0);
        String begDay = pastDate + " 0:00:00";
        String endDay = pastDate + " 23:59:59";

        if (searchDate != null) {
            begDay = searchDate.subSequence(0, 10) + " 0:00:00";
            endDay = searchDate.subSequence(13, 23) + " 23:59:59";
        }
        String tbName = ("eventupgradelvl_" + begDay.subSequence(0, 10)).replace("-", "");
        List<UserLevel> userLevels = userBehaviorDao.queryUserLevel(tbName, DateUtil.strToStamp(begDay), DateUtil.strToStamp(endDay), platformId, checkId);
        System.out.println(userLevels);


        return userLevels;
    }

    /**
     * 留存用户关卡成长跟踪
     *
     * @param searchDate
     * @param platformId
     * @return
     */
    public List<RetenPlann> retentionPlan(String searchDate, Integer platformId) {
        List<RetenPlann> retenPlannList = new ArrayList<>();
        List<List<Plann>> planList = new ArrayList<>();
        //默认15日的日期
        String fiftenDate = DateUtil.getPastDate(-14);
        //查询的注册时间 不变定义在外面
        String begRegTime = DateUtil.getPastDate(0) + " 00:00:00";
        String endRegTime = DateUtil.getPastDate(0) + " 23:59:59";
        //获取当天到15日留存日期集合
        List<String> betweenDate = DateUtil.getBetweenDate(DateUtil.getPastDate(0) + "", fiftenDate);
        if (searchDate != null) {
            String begDate = searchDate.subSequence(0, 10) + "";
            fiftenDate = DateUtil.getDateAfter(begDate, 14, "yyyy-MM-dd");
            begRegTime = searchDate.subSequence(0, 10) + " 00:00:00";
            endRegTime = searchDate.subSequence(0, 10) + " 23:59:59";
            betweenDate = DateUtil.getBetweenDate(begDate, fiftenDate);

        }

        Integer maxLevelId = 0;

        //查询所有天的关卡
        for (int i = 0; i < betweenDate.size(); i++) {
            String tbName = ("eventclearaward_" + betweenDate.get(i).replace("-", ""));
            System.out.println(tbName);
            List<Plann> planns = new ArrayList<>();
            try {
                planns = plannDao.queryPlann(tbName, DateUtil.strToStamp(begRegTime), DateUtil.strToStamp(endRegTime), platformId, 1);
            } catch (Exception e) {
                System.out.println("SQL查询异常:");
            } finally {
                planList.add(planns);
                //获取最大关卡id
                for (int j = 0; j < planns.size(); j++) {
                    maxLevelId = maxLevelId > planns.get(j).getLevelId() ? maxLevelId : planns.get(j).getLevelId();
                }
            }
        }
        //获取最大的Level的集合
        List<Integer> maxLevelidList = UserUtil.getList(maxLevelId);

        for (int i = 0; i < planList.size(); i++) {

            //1.获取planList中指定list中所有id存入 idList
            List idList = new ArrayList();
            for (int l = 0; l < planList.get(i).size(); l++) {
                idList.add(planList.get(i).get(l).getLevelId());
            }
            //2.获取需要补齐的levelid
            List<Integer> addList = new ArrayList<>();
            //
            for (int j = 0; j < maxLevelidList.size(); j++) {
                if (idList.contains(maxLevelidList.get(j)) == false) {
                    addList.add(maxLevelidList.get(j));
                }
            }

            //2.补齐levelid
            //补齐list
            for (int k = 0; k < addList.size(); k++) {
                planList.get(i).add(new Plann((int) addList.get(k), 0));
            }
        }
        //构造1-maxLevelidList.size() 个数据
        for (int i = 0; i < maxLevelidList.size(); i++) {
            RetenPlann retenPlann = new RetenPlann();
            retenPlann.setLevelId(maxLevelidList.get(i));
            for (int j = 0; j <maxLevelidList.size(); j++) {
                if (planList.get(0).get(j).getLevelId().equals(maxLevelidList.get(i)) ) {
                    retenPlann.setNum01(planList.get(0).get(j).getUserNum());
                }
                if (planList.get(1).get(j).getLevelId().equals(maxLevelidList.get(i))) {
                    retenPlann.setNum02(planList.get(1).get(j).getUserNum());
                }
                if (planList.get(2).get(j).getLevelId().equals(maxLevelidList.get(i))) {
                    retenPlann.setNum03(planList.get(2).get(j).getUserNum());
                }
                if (planList.get(3).get(j).getLevelId().equals(maxLevelidList.get(i))) {
                    retenPlann.setNum04(planList.get(3).get(j).getUserNum());
                }
                if (planList.get(4).get(j).getLevelId().equals(maxLevelidList.get(i))) {
                    retenPlann.setNum05(planList.get(4).get(j).getUserNum());
                }
                if (planList.get(5).get(j).getLevelId().equals(maxLevelidList.get(i))) {
                    retenPlann.setNum06(planList.get(5).get(j).getUserNum());
                }
                if (planList.get(6).get(j).getLevelId().equals(maxLevelidList.get(i))) {
                    retenPlann.setNum07(planList.get(6).get(j).getUserNum());
                }
                if (planList.get(7).get(j).getLevelId().equals(maxLevelidList.get(i))) {
                    retenPlann.setNum08(planList.get(7).get(j).getUserNum());
                }
                if (planList.get(8).get(j).getLevelId().equals(maxLevelidList.get(i))) {
                    retenPlann.setNum09(planList.get(8).get(j).getUserNum());
                }
                if (planList.get(9).get(j).getLevelId().equals(maxLevelidList.get(i))) {
                    retenPlann.setNum10(planList.get(9).get(j).getUserNum());
                }
                if (planList.get(10).get(j).getLevelId().equals(maxLevelidList.get(i))) {
                    retenPlann.setNum11(planList.get(10).get(j).getUserNum());
                }
                if (planList.get(11).get(j).getLevelId().equals(maxLevelidList.get(i))) {
                    retenPlann.setNum12(planList.get(11).get(j).getUserNum());
                }
                if (planList.get(12).get(j).getLevelId().equals(maxLevelidList.get(i))) {
                    retenPlann.setNum13(planList.get(12).get(j).getUserNum());
                }
                if (planList.get(13).get(j).getLevelId().equals(maxLevelidList.get(i))) {
                    retenPlann.setNum14(planList.get(13).get(j).getUserNum());
                }
                if (planList.get(14).get(j).getLevelId().equals(maxLevelidList.get(i))) {
                    retenPlann.setNum15(planList.get(14).get(j).getUserNum());
                }

            }

            retenPlannList.add(retenPlann);
        }


        return retenPlannList;
    }

    /**
     * 留存用户等级成长跟踪
     *
     * @param searchDate
     * @param platformId
     * @return
     */
    public List<Level> queryLevel(String searchDate, Integer platformId) {
        List<List<Plann>> planList = new ArrayList<>();
        List<Level> levList = new ArrayList<>();

        String begDay = DateUtil.getPastDate(0);
        if (searchDate != null) {
            begDay = searchDate.subSequence(0, 10) + "";
        }
        List<String> betweenDate = DateUtil.getBetweenDate(begDay, DateUtil.getDateByNum(begDay, 6));
        Integer maxLev = 0;

        for (int i = 0; i < betweenDate.size(); i++) {
            String tbName = ("eventupgradelvl_" + betweenDate.get(i).replace("-", ""));
            List<Plann> planns=new ArrayList<>();
            try{
                planns= userBehaviorDao.queryLevel(tbName,DateUtil.strToStamp(betweenDate.get(i) + " 0:00:00"), DateUtil.strToStamp(betweenDate.get(i) + " 23:59:59"), DateUtil.strToStamp(begDay + " 0:00:00"), DateUtil.strToStamp(begDay + " 23:59:59"), platformId);

            }catch (Exception e)
            {
                System.out.println("SQL查询异常："+e.getMessage());
            }finally
            {
                planList.add(planns);
            }

            //获取最大等级
            for (int j = 0; j < planns.size(); j++) {
                maxLev = maxLev > planns.get(j).getLevelId() ? maxLev : planns.get(j).getLevelId();
            }
        }
        for (int l = 0; l < planList.size(); l++) {
            List idList = new ArrayList();
            List addList = new ArrayList();
            //获取planList中指定个list中所有id存入 idList
            for (int i = 0; i < planList.get(l).size(); i++)
            {
                idList.add(planList.get(l).get(i).getLevelId());
            }
            //获取需要补齐的id(0-最大等级中 不在idList中的id)
            for (int i = 1; i <= maxLev; i++)
            {
                if (idList.contains(i) == false)
                {
                    addList.add(i);
                }
            }
            //补齐list
            for (int i = 0; i < addList.size(); i++) {
                planList.get(l).add(new Plann((int) addList.get(i), 0));
            }
        }
        //构造1-maxLev 个数据
        for (int i = 1; i <= maxLev; i++) {
            Level level = new Level();
            for (int j = 0; j < maxLev; j++) {
                if (planList.get(0).get(j).getLevelId() == i) {
                    level.setLevel01(i);
                    level.setNum01(planList.get(0).get(j).getUserNum());
                }
                if (planList.get(1).get(j).getLevelId() == i) {
                    level.setLevel02(i);
                    level.setNum02(planList.get(1).get(j).getUserNum());
                }
                if (planList.get(2).get(j).getLevelId() == i) {
                    level.setLevel03(i);
                    level.setNum03(planList.get(2).get(j).getUserNum());
                }
                if (planList.get(3).get(j).getLevelId() == i) {
                    level.setLevel04(i);
                    level.setNum04(planList.get(3).get(j).getUserNum());
                }
                if (planList.get(4).get(j).getLevelId() == i) {
                    level.setLevel05(i);
                    level.setNum05(planList.get(4).get(j).getUserNum());
                }
                if (planList.get(5).get(j).getLevelId() == i) {
                    level.setLevel06(i);
                    level.setNum06(planList.get(5).get(j).getUserNum());
                }
                if (planList.get(6).get(j).getLevelId() == i) {
                    level.setLevel07(i);
                    level.setNum07(planList.get(6).get(j).getUserNum());
                }
            }

            levList.add(level);
        }
        return levList;
    }


    public List<List<Plann>> queryLevelUtil(String searchDate, Integer platformId) {
        List<List<Plann>> planList = new ArrayList<>();

        String begDay = DateUtil.getPastDate(7);
        if (searchDate != null) {
            begDay = searchDate.subSequence(0, 10) + "";
        }
        List<String> betweenDate = DateUtil.getBetweenDate(begDay, DateUtil.getDateByNum(begDay, 6));
        Integer maxLev = 0;
        for (int i = 0; i < betweenDate.size(); i++) {
            String tbName = ("eventupgradelvl_" + betweenDate.get(i).replace("-", ""));
            List<Plann> planns = userBehaviorDao.queryLevel(tbName,DateUtil.strToStamp(betweenDate.get(i) + " 0:00:00"), DateUtil.strToStamp(betweenDate.get(i) + " 23:59:59"), DateUtil.strToStamp(begDay + " 0:00:00"), DateUtil.strToStamp(begDay + " 23:59:59"), platformId);
            planList.add(planns);
        }

        return planList;
    }

    public List<UserItemFlow> queryItemFlow(String searchDate,Integer uin,Integer zoneId,Integer itemType)
    {
        List<UserItemFlow> userItemFlows = new ArrayList<>();
        //格式化道具名称
        Map<String, String> map = ReadExcel.readXlsmToMap("config/Item.xlsm","Item",9,1,3);
        Map<String, String> saleItemMap = ReadExcel.readXlsmToMap("config/Item.xlsm","SaleItem",9,4,2);
        map.putAll(saleItemMap);
        if(searchDate!="" && uin!=null && zoneId!=null && itemType!=null)
        {
            String begDay=(String)searchDate.subSequence(0, 10);
            String endDay=(String)searchDate.subSequence(13, 23);
            List<String> betweenDate=DateUtil.getBetweenDate(begDay, endDay);
            Collections.reverse(betweenDate);
            for(int i=0;i<betweenDate.size();i++)
            {
                String tbName = ("eventcoinflow_" + betweenDate.get(i)).replace("-", "");
                if(itemType==2)
                {
                    tbName = ("eventdiamondflow_" + betweenDate.get(i)).replace("-", "");
                }else if(itemType==3)
                {

                    tbName = ("eventitemflow_" + betweenDate.get(i)).replace("-", "");
                }
                List<UserItemFlow> userItemFlow = userBehaviorDao.queryItemFlow(tbName, zoneId, uin);
                userItemFlows.addAll(userItemFlow);

            }
            //格式化道具名称
            for(int i=0;i<userItemFlows.size();i++)
            {
                userItemFlows.get(i).setStrTs(DateUtil.timestampToString(userItemFlows.get(i).getTs()));
                userItemFlows.get(i).setStrReason(UserUtil.getReasonName(userItemFlows.get(i).getReason()));
                userItemFlows.get(i).setStrItemName(map.get(String.valueOf(userItemFlows.get(i).getItemId()))==null?String.valueOf(userItemFlows.get(i).getItemId()):map.get(String.valueOf(userItemFlows.get(i).getItemId())));
            }

        }


        return  userItemFlows;
    }


    /**玩家充值查询*/
    public List<EventCharge> queryUserCharge(String searchDate, Integer uin)
    {
        List<EventCharge> eventChargeList = new ArrayList<>();

        //格式化道具名称
        Map<String, String> map = ReadExcel.readXlsmToMap("config/Item.xlsm","SaleLimitItem",9,1,2);
        Map<String, String> saleItemMap = ReadExcel.readXlsmToMap("config/Item.xlsm","SaleItem",9,4,2);
        map.putAll(saleItemMap);

        if(searchDate!="" &&uin!=null)
        {
            String begDay=(String)searchDate.subSequence(0, 10);
            String endDay=(String)searchDate.subSequence(13, 23);
            List<String> betweenDate=DateUtil.getBetweenDate(begDay, endDay);
            Collections.reverse(betweenDate);
            for(int i=0;i<betweenDate.size();i++)
            {
                String tbName = ("eventcharge_" + betweenDate.get(i)).replace("-", "");
                try{
                    List<EventCharge> eventCharges = userBehaviorDao.queryUserCharge(tbName, uin);
                    System.out.println(eventCharges);
                    eventChargeList.addAll(eventCharges);
                }catch(Exception e)
                {
                    System.out.println("SQL查询异常："+e.getMessage());
                }

            }
            //设置道具name
            for(int i=0;i<eventChargeList.size();i++)
            {
                eventChargeList.get(i).setItemName(map.get(String.valueOf(map.get(String.valueOf(eventChargeList.get(i).getItemId())))));
            }

        }
        return eventChargeList;
    }

}
