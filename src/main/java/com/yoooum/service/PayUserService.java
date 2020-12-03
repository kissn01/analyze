package com.yoooum.service;

import com.yoooum.dao.PayUserDao;
import com.yoooum.dao.PublicDao;
import com.yoooum.domain.*;
import com.yoooum.util.CollectionUtil;
import com.yoooum.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @创建人: ${kiss}
 * @时间: 2020/2/4 16:19
 * @描述:
 */

@Service
public class PayUserService
{

    @Autowired
    private PayUserDao payUserDao;

    @Autowired
    private PublicDao  publicDao;

    //保留2位小数
    private static DecimalFormat df=new DecimalFormat("0.00");

    //查询玩家留存
    public List<MyUserRetention> querMyRetentions(String searchDate, Integer platformId)
    {

        List<MyUserRetention> MyUserRetentions = new ArrayList<>();
        //默认查询最近7天
        List<String> betweenDate = DateUtil.getLastSevenDay(0,7);
        if(searchDate != null)
        {
            String begDay=(String)searchDate.subSequence(0, 10);
            String endDay=(String)searchDate.subSequence(13, 23);
            betweenDate = DateUtil.getBetweenDate(begDay, endDay);
            Collections.reverse(betweenDate);
        }
        for(int i=0;i<betweenDate.size();i++)
        {
            MyUserRetention myUserRetention = new MyUserRetention();
            try{
                //0.拼接
                String sufTbName=betweenDate.get(i).replace("-","");
                //1.设置时间
                myUserRetention.setMyDate(betweenDate.get(i));
                //2.新增玩家
                Integer register = payUserDao.queryPayUser("eventcharge_" + sufTbName, platformId);
                myUserRetention.setNewAddUser(register!=null?register:0);
               /* //3.活跃玩家
                Integer dau = publicDao.queryDau("eventlogin_" + sufTbName, platformId);
                myUserRetention.setActiveUser(dau!=null?dau:0);*/
                //4. 次日留存
                myUserRetention.setTwoDayRet(register!=null?df.format((float)queryRetention(betweenDate.get(i), 1, platformId)*100/register):"0.00");
                //5. 3日留存
                myUserRetention.setThreeDayRet(register!=null?df.format((float)queryRetention(betweenDate.get(i), 2, platformId)*100/register):"0.00");
                //6. 4日留存
                myUserRetention.setFourDayRet(register!=null?df.format((float)queryRetention(betweenDate.get(i), 3, platformId)*100/register):"0.00");
                //7. 5日留存
                myUserRetention.setFiveDayRet(register!=null?df.format((float)queryRetention(betweenDate.get(i), 4, platformId)*100/register):"0.00");
                //8. 6日留存
                myUserRetention.setSixDayRet(register!=null?df.format((float)queryRetention(betweenDate.get(i), 5, platformId)*100/register):"0.00");
                //9. 7日留存
                myUserRetention.setSevenDayRet(register!=null?df.format((float)queryRetention(betweenDate.get(i), 6, platformId)*100/register):"0.00");
                //10. 8日留存
                myUserRetention.setEightDayRet(register!=null?df.format((float)queryRetention(betweenDate.get(i), 7, platformId)*100/register):"0.00");
                //11. 9日留存
                myUserRetention.setNineDayRet(register!=null?df.format((float)queryRetention(betweenDate.get(i), 8, platformId)*100/register):"0.00");
                //12. 10日留存
                myUserRetention.setTenDayRet(register!=null?df.format((float)queryRetention(betweenDate.get(i), 9, platformId)*100/register):"0.00");
                //13. 11日留存
                myUserRetention.setElevenDayRet(register!=null?df.format((float)queryRetention(betweenDate.get(i), 10, platformId)*100/register):"0.00");
                //14. 12日留存
                myUserRetention.setTwelveDayRet(register!=null?df.format((float)queryRetention(betweenDate.get(i), 11, platformId)*100/register):"0.00");
                //15. 13日留存
                myUserRetention.setThirteenDayRet(register!=null?df.format((float)queryRetention(betweenDate.get(i), 12, platformId)*100/register):"0.00");
                //16. 14日留存
                myUserRetention.setFourteenDayRet(register!=null?df.format((float)queryRetention(betweenDate.get(i), 13, platformId)*100/register):"0.00");
                //17. 15日留存
                myUserRetention.setFifteenDayRet(register!=null?df.format((float)queryRetention(betweenDate.get(i), 14, platformId)*100/register):"0.00");
                //18. 30日留存
                myUserRetention.setThirtyDayRet(register!=null?df.format((float)queryRetention(betweenDate.get(i), 29, platformId)*100/register):"0.00");
                //19. 60日留存
                myUserRetention.setSixtyDayRet(register!=null?df.format((float)queryRetention(betweenDate.get(i), 59, platformId)*100/register):"0.00");
            }catch (Exception e)
            {
                System.out.println("SQL查询异常："+e.getMessage());
            }
            MyUserRetentions.add(myUserRetention);
        }

        return MyUserRetentions;

    }

    //获取指定日期注册uin和他前(后)n天登陆用户uin相同的个数
    public int queryRetention(String checkDate,int passDate,Integer platformId) {
        //1)获取当天注册uin
        List<Integer> regUinList = payUserDao.getUinList("eventcharge_" + checkDate.replace("-", ""), platformId);
        //2)获取次日登陆uin
        List<Integer> loginUinList = new ArrayList<>();
        try {
            loginUinList = publicDao.queryLoginUin("eventlogin_" + DateUtil.getDateAfter(checkDate, passDate, "yyyyMMdd"), platformId);
        } catch (Exception e) {
            System.out.println("SQL查询异常或日期转换异常！");
        }
        //3)获取集合中相同元素的个数
        int sanmeSize = CollectionUtil.getSame(regUinList, loginUinList).size();

        return sanmeSize;

    }

    //付费用户等级分布
    public Map<Integer,Long> queryLevel(String searchDate, Integer platformId)
    {
        //默认查询当天
        if(searchDate == null)
        {
            searchDate=DateUtil.getPastDate(1);
        }

        String tbDate= ((String)searchDate.subSequence(0, 10)).replace("-","");
        //1.获取所有付费玩家 uin
        List<Integer> uinList = new ArrayList<>();
        try {
            uinList=payUserDao.getUinList("eventcharge_"+tbDate,platformId);
        }catch (Exception e)
        {
            System.out.println("SQL查询异常"+e.getMessage());
        }

        //2.循环获取付费用户所有等级
        List<Integer> levleList= new ArrayList<>();
        Integer level=0;
        for(int i=0;i<uinList.size();i++)
        {
            try {
                level=payUserDao.queryUserLevel("eventupgradelvl_"+tbDate, uinList.get(i));
                if(null!=level)
                {
                    levleList.add(level);
                }
            }catch (Exception e)
            {
                System.out.println("SQL查询异常"+e.getMessage());
            }

        }


        //统计list中每个元素个数 存入map //统计集合重复元素出现次数，并且去重返回hashmap
        Map<Integer,Long> LevelMap = levleList.stream().
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        //map 按key 排序
        TreeMap<Integer, Long> paramTreeMap = new TreeMap<>(LevelMap);

        return paramTreeMap;
    }
    //付费用户关卡开启分布
    public List<PlanOpenCount> queryPass(String searchDate, Integer platformId)
    {
        List<PlanOpenCount> planOpenCountList = new ArrayList<>();
        List<String> lastSevenDay = DateUtil.getLastSevenDay(0,7);
        //默认查询最近一周
        if(searchDate!= null)
        {
            lastSevenDay  =DateUtil.getBetweenDate((String)searchDate.subSequence(0, 10), (String)searchDate.subSequence(13, 23));
        }
        for (int i=0;i<lastSevenDay.size();i++)
        {
            PlanOpenCount planOpenCount = queryPassUtil(lastSevenDay.get(i), platformId);
            planOpenCountList.add(planOpenCount);
        }
        return planOpenCountList;
    }

    //付费用户关卡开启分布工具类
    public  PlanOpenCount queryPassUtil(String searchDate, Integer platformId)
    {

        String tbDate= ((String)searchDate.subSequence(0, 10)).replace("-","");
        //1.获取所有付费玩家 uin
        List<Integer> uinList = new ArrayList<>();
        try {
            uinList=payUserDao.getUinList("eventcharge_"+tbDate,platformId);
        }catch (Exception e)
        {
            System.out.println("SQL查询异常"+e.getMessage());
        }

        //2.循环获取付费用户关卡开启次数
        PlanOpenCount planOpenCount = new PlanOpenCount();
        float  openAvg  = 0.00f;
        Integer  openOne = 0;
        Integer  openTwo = 0;
        Integer  openThree = 0;
        Integer  openFour = 0;
        Integer  openFive = 0;
        Integer  openST = 0;
        Integer  openGtT = 0;
        Integer count=0;
        Integer sumCount=0;
        for(int i=0;i<uinList.size();i++)
        {
            try {
                count=payUserDao.queryUserPass("eventclearaward_"+tbDate, uinList.get(i));
                sumCount+=count;

                if(count==1)
                {
                    openOne++;
                }else if(count==2){
                    openTwo++;
                }else if(count==3){
                    openThree++;
                }else if(count==4){
                    openFour++;
                }else if(count==5){
                    openFive++;
                }else if(count>=6&&count<=10){
                    openST++;
                }else if(count>10){
                    openGtT++;
                }
            }catch (Exception e)
            {
                System.out.println("SQL查询异常"+e.getMessage());
            }

        }

        if(uinList.size()!=0)
        {
            openAvg=Float.parseFloat(df.format((float)sumCount/uinList.size()));
        }
        planOpenCount.setMyDate(searchDate);
        planOpenCount.setOpenAvg(openAvg);
        planOpenCount.setOpenOne(openOne);
        planOpenCount.setOpenTwo(openTwo);
        planOpenCount.setOpenThree(openThree);
        planOpenCount.setOpenFour(openFour);
        planOpenCount.setOpenFive(openFive);
        planOpenCount.setOpenST(openST);
        planOpenCount.setOpenGtT(openGtT);
        return planOpenCount;

    }

    //付费用户钻石消耗途径
    public List<SubDiamond> queryPayDiamod(String searchDate, Integer platformId)
    {
        List<SubDiamond> subDiamonds = new ArrayList<>();
        List<String> betweenDate = DateUtil.getLastSevenDay(0,7);
        if(searchDate!=null)
        {
            betweenDate = DateUtil.getBetweenDate(searchDate.subSequence(0,10 )+"", searchDate.subSequence(13,23)+"");
        }
        for (int l=0;l<betweenDate.size();l++)
        {
            //1.获取当日充值的用户uin
            List<Integer> uinList = new ArrayList<>();
            try {
                uinList=payUserDao.getUinList("eventcharge_"+betweenDate.get(l).replace("-",""),platformId);
            }catch (Exception e)
            {
                System.out.println("SQL查询异常"+e.getMessage());
            }
            //2.获取用户钻石消耗
            try{
                List<Plann> planns = payUserDao.queryPayDiamod("eventdiamondflow_"+ betweenDate.get(l).replace("-",""), uinList);
                SubDiamond subDiamond = new SubDiamond(betweenDate.get(l),0,0,0,0,0,0,0,0);
                Integer subSum = 0;
                for (int i = 0; i < planns.size(); i++) {
                    subSum += planns.get(i).getUserNum();
                    if (planns.get(i).getLevelId() == 4) {
                        subDiamond.setSubNatural(-planns.get(i).getUserNum());
                    }
                    if (planns.get(i).getLevelId() == 8) {
                        subDiamond.setSubShop(-planns.get(i).getUserNum());
                    }
                    if (planns.get(i).getLevelId() == 21) {
                        subDiamond.setSubGold(-planns.get(i).getUserNum());
                    }
                    if (planns.get(i).getLevelId() == 12) {
                        subDiamond.setSubRevice(-planns.get(i).getUserNum());
                    }
                    if (planns.get(i).getLevelId() == 29) {
                        subDiamond.setSubChallenge(-planns.get(i).getUserNum());
                    }
                    if (planns.get(i).getLevelId() == 40) {
                        subDiamond.setSubMedal(-planns.get(i).getUserNum());
                    }
                    if (planns.get(i).getLevelId() == 9) {
                        subDiamond.setSubOpenBox(-planns.get(i).getUserNum());
                    }
                }
                //设置日期,体力和总消耗
                subDiamond.setSubSum(subSum);
                subDiamonds.add(subDiamond);
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

        }

        return subDiamonds;
    }


    //付费用户遗物抽取总览
    public List<NaturalLottery> queryPayNatural(String searchDate,Integer platformId,Integer chapterId)
    {
        //默认查询第一层
        if(chapterId==null)
        {
            chapterId = 1;
        }
        List<NaturalLottery> naturalLotteryList = new ArrayList<>();
        List<String> betweenDate = DateUtil.getLastSevenDay(0,4);
        if(searchDate!=null)
        {
            betweenDate = DateUtil.getBetweenDate(searchDate.subSequence(0,10 )+"", searchDate.subSequence(13,23)+"");
        }
        for (int l=0;l<betweenDate.size();l++)
        {
            //1.获取当日充值的用户uin
            List<Integer> uinList = new ArrayList<>();
            try {
                uinList=payUserDao.getUinList("eventcharge_"+betweenDate.get(l).replace("-",""),platformId);
            }catch (Exception e)
            {
                System.out.println("SQL查询异常"+e.getMessage());
            }

            //2.获取付费用户遗物抽取情况
            try{
                List<Natural> naturalList = payUserDao.queryPayNatural("eventnatural_"+ betweenDate.get(l).replace("-",""),chapterId, uinList);

                NaturalLottery naturalLottery = new NaturalLottery();
                naturalLottery.setFreeNum(0);
                naturalLottery.setAvgDiamond("0.00");
                naturalLottery.setAvgGold("0.00");
                naturalLottery.setAvgNatural("0.00");
                naturalLottery.setDiamondNum(0);
                naturalLottery.setDiamondRatio("0.0");
                naturalLottery.setFreeRatio("0.00");
                naturalLottery.setGoldNum(0);
                naturalLottery.setGoldRatio("0.00");
                naturalLottery.setNaturalNum(0);
                naturalLottery.setNaturalRatio("0.00");
                //获得dau
                //Integer dau = publicDao.queryDau( ("eventlogin_"+ betweenDate.get(l).subSequence(0, 10)).replace("-",""),  platformId);
                Integer dau=uinList.size();
                //设置dau和时间
                naturalLottery.setDate(betweenDate.get(l).subSequence(0, 10)+"");
                naturalLottery.setDau(dau);

                for (int i=0;i<naturalList.size();i++)
                {
                    if(naturalList.get(i).getCostType()==0)
                    {
                        naturalLottery.setFreeNum(naturalList.get(i).getProsonNum());
                        naturalLottery.setFreeRatio(df.format((float)naturalList.get(i).getProsonNum()*100/dau));
                    }else if(naturalList.get(i).getCostType()==1)
                    {
                        naturalLottery.setGoldNum(naturalList.get(i).getProsonNum());
                        naturalLottery.setGoldRatio(df.format((float)naturalList.get(i).getProsonNum()*100/dau));
                        naturalLottery.setAvgGold(df.format(naturalList.get(i).getAvgMoney()));
                    }
                    else if(naturalList.get(i).getCostType()==2)
                    {
                        naturalLottery.setDiamondNum(naturalList.get(i).getProsonNum());
                        naturalLottery.setDiamondRatio(df.format((float)naturalList.get(i).getProsonNum()*100/dau));
                        naturalLottery.setAvgDiamond(df.format(naturalList.get(i).getAvgMoney()));
                    }
                    else if(naturalList.get(i).getCostType()==12)
                    {
                        naturalLottery.setNaturalNum(naturalList.get(i).getProsonNum());
                        naturalLottery.setNaturalRatio(df.format((float)naturalList.get(i).getProsonNum()*100/dau));
                        naturalLottery.setAvgNatural(df.format(naturalList.get(i).getAvgMoney()));
                    }
                }
                naturalLotteryList.add(naturalLottery);
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

        }

        return naturalLotteryList;
    }


}
