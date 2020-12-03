package com.yoooum.service;

import com.yoooum.dao.OperationsDao;
import com.yoooum.dao.PublicDao;
import com.yoooum.domain.*;
import com.yoooum.util.CollectionUtil;
import com.yoooum.util.DateUtil;
import com.yoooum.util.ReadExcel;
import com.yoooum.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/18 19:49
 * @描述:
 */
@Service
public class OperationsServices {
    @Autowired
    private OperationsDao operationsDao;

    @Autowired
    private PublicDao publicDao;

    //保留2位小数
    private static DecimalFormat df = new DecimalFormat("0.00");

    //运营数据总揽
    public List<MyOperationData> querOperationsDatas(String searchDate, Integer platformId) {
        List<MyOperationData> myOperationDatas = new ArrayList<>();
        //默认查询最近7天
        List<String> betweenDate = DateUtil.getLastSevenDay(0, 7);
        if (searchDate != null) {
            String begDay = (String) searchDate.subSequence(0, 10);
            String endDay = (String) searchDate.subSequence(13, 23);
            betweenDate = DateUtil.getBetweenDate(begDay, endDay);
        }
        for (int i = 0; i < betweenDate.size(); i++) {
            MyOperationData myOperationData = new MyOperationData();
            //0.拼接
            String sufTbName = betweenDate.get(i).replace("-", "");
            //1.设置时间
            myOperationData.setMyDate(betweenDate.get(i));
            //2.新增玩家
            Integer register = publicDao.queryRegister("eventregister_" + sufTbName, platformId);
            myOperationData.setNewAddUser(register != null ? register : 0);
            //3.活跃玩家
            Integer dau = publicDao.queryDau("eventlogin_" + sufTbName, platformId);
            myOperationData.setActiveUser(dau != null ? dau : 0);
            //4.充值玩家
            Integer chargeNum = publicDao.queryChargeNum("eventcharge_" + sufTbName, platformId);
            myOperationData.setChargeUser(chargeNum != null ? chargeNum : 0);
            //5.充值金额
            Integer chargeSum = publicDao.queryCharge("eventcharge_" + sufTbName, platformId);
            myOperationData.setChargeAmount(chargeSum != null ? chargeSum / 100 : 0);
            //6.活跃用户ARPU  当天的总收入/DAU
            String arppu = dau != 0 ? df.format((float) chargeSum / dau / 100) : "0.00";
            myOperationData.setArppu(arppu);
            //7.总付费用户ARPU  当天的总收入/当天的付费用户总数
            myOperationData.setArpu(chargeNum != 0 ? df.format((float) chargeSum / chargeNum / 100) : "0.00");
            //8.充值渗透率  充值玩家/活跃玩家
            myOperationData.setPur(dau != 0 ? df.format((float) chargeNum * 100 / dau) : "0.00");
            //9.次日留存:次日的登陆人数除以当天注册人数
            myOperationData.setMorrowRetention(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 1, platformId) * 100 / register) : "0.00");
            //10.三日留存
            myOperationData.setThreeDayRetention(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 2, platformId) * 100 / register) : "0.00");
            //11.七日留存
            myOperationData.setSevenDayRetention(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 6, platformId) * 100 / register) : "0.00");
            //12.十五日留存
            myOperationData.setFifteenDayRetention(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 14, platformId) * 100 / register) : "0.00");

            myOperationDatas.add(myOperationData);
        }


        return myOperationDatas;
    }

    //查询玩家留存
    public List<MyUserRetention> querMyRetentions(String searchDate, Integer platformId) {

        List<MyUserRetention> MyUserRetentions = new ArrayList<>();
        //默认查询最近7天
        List<String> betweenDate = DateUtil.getLastSevenDay(0, 7);
        if (searchDate != null) {
            String begDay = (String) searchDate.subSequence(0, 10);
            String endDay = (String) searchDate.subSequence(13, 23);
            betweenDate = DateUtil.getBetweenDate(begDay, endDay);
            Collections.reverse(betweenDate);
        }
        for (int i = 0; i < betweenDate.size(); i++) {
            MyUserRetention myUserRetention = new MyUserRetention();
            //0.拼接
            String sufTbName = betweenDate.get(i).replace("-", "");
            //1.设置时间
            myUserRetention.setMyDate(betweenDate.get(i));
            //2.新增玩家
            Integer register = publicDao.queryRegister("eventregister_" + sufTbName, platformId);
            myUserRetention.setNewAddUser(register != null ? register : 0);
            //3.活跃玩家
            Integer dau = publicDao.queryDau("eventlogin_" + sufTbName, platformId);
            myUserRetention.setActiveUser(dau != null ? dau : 0);
            //4. 次日留存
            myUserRetention.setTwoDayRet(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 1, platformId) * 100 / register) : "0.00");
            //5. 3日留存
            myUserRetention.setThreeDayRet(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 2, platformId) * 100 / register) : "0.00");
            //6. 4日留存
            myUserRetention.setFourDayRet(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 3, platformId) * 100 / register) : "0.00");
            //7. 5日留存
            myUserRetention.setFiveDayRet(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 4, platformId) * 100 / register) : "0.00");
            //8. 6日留存
            myUserRetention.setSixDayRet(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 5, platformId) * 100 / register) : "0.00");
            //9. 7日留存
            myUserRetention.setSevenDayRet(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 6, platformId) * 100 / register) : "0.00");
            //10. 8日留存
            myUserRetention.setEightDayRet(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 7, platformId) * 100 / register) : "0.00");
            //11. 9日留存
            myUserRetention.setNineDayRet(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 8, platformId) * 100 / register) : "0.00");
            //12. 10日留存
            myUserRetention.setTenDayRet(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 9, platformId) * 100 / register) : "0.00");
            //13. 11日留存
            myUserRetention.setElevenDayRet(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 10, platformId) * 100 / register) : "0.00");
            //14. 12日留存
            myUserRetention.setTwelveDayRet(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 11, platformId) * 100 / register) : "0.00");
            //15. 13日留存
            myUserRetention.setThirteenDayRet(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 12, platformId) * 100 / register) : "0.00");
            //16. 14日留存
            myUserRetention.setFourteenDayRet(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 13, platformId) * 100 / register) : "0.00");
            //17. 15日留存
            myUserRetention.setFifteenDayRet(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 14, platformId) * 100 / register) : "0.00");
            //18. 30日留存
            myUserRetention.setThirtyDayRet(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 29, platformId) * 100 / register) : "0.00");
            //19. 60日留存
            myUserRetention.setSixtyDayRet(register != null && register!=0 ? df.format((float) queryRetention(betweenDate.get(i), 59, platformId) * 100 / register) : "0.00");

            MyUserRetentions.add(myUserRetention);
        }

        return MyUserRetentions;

    }

    //获取指定日期注册uin和他前(后)n天登陆用户uin相同的个数
    public int queryRetention(String checkDate, int passDate, Integer platformId) {
        //1)获取当天注册uin
        List<Integer> regUinList = publicDao.queryRegUin("eventregister_" + checkDate.replace("-", ""), platformId);
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

    //用户付费解析
    public List<AnalysisPay> queryAnalysisPays(String searchDate, Integer platformId) {
        List<AnalysisPay> analysisPays = new ArrayList<>();
        //默认查询最近7天
        List<String> betweenDate = DateUtil.getLastSevenDay(0, 7);
        if (searchDate != null) {
            String begDay = (String) searchDate.subSequence(0, 10);
            String endDay = (String) searchDate.subSequence(13, 23);
            betweenDate = DateUtil.getBetweenDate(begDay, endDay);
        }
        for (int i = 0; i < betweenDate.size(); i++) {
            AnalysisPay analysisPay = new AnalysisPay();
            analysisPay.setTimeSign(betweenDate.get(i));
            // 0.设置时间
            analysisPay.setTimeSign(betweenDate.get(i));
            Integer register = 0;
            int newChargeNum = 0;
            int newCharge = 0;
            Integer chargeSum = 0;
            Integer dau = 0;
            Integer chargeNum = 0;
            String arppu = "0.00";

            // 1.拼接
            String sufTbName = betweenDate.get(i).replace("-", "");
            try {
                // 2.新增用户数
                register = publicDao.queryRegister("eventregister_" + sufTbName, platformId);
            } catch (Exception e) {
                System.out.println("SQL查询异常：" + e);
            }
            try {
                // 3.新进用户的付费人数
                newChargeNum = publicDao.queryChargeNumByReg("eventcharge_" + sufTbName,
                        DateUtil.strToStamp(betweenDate.get(i) + " 0:00:00"),
                        DateUtil.strToStamp(betweenDate.get(i) + " 23:59:59"), platformId);
            } catch (Exception e) {
                System.out.println("SQL查询异常：" + e);
            }
            try {
                // 4.新增用户付费金额
                newCharge = publicDao.queryNewCharge("eventcharge_" + sufTbName,
                        DateUtil.strToStamp(betweenDate.get(i) + " 0:00:00"),
                        DateUtil.strToStamp(betweenDate.get(i) + " 23:59:59"), platformId) / 100;
            } catch (Exception e) {
                System.out.println("SQL查询异常：" + e);
            }
            try {

                // 1.总付费金额
                chargeSum = publicDao.queryCharge("eventcharge_" + sufTbName, platformId) / 100;
            } catch (Exception e) {
                System.out.println("SQL查询异常：" + e);
            }
            try {
                // 2.DAU
                dau = publicDao.queryDau("eventlogin_" + sufTbName, platformId);
            } catch (Exception e) {
                System.out.println("SQL查询异常：" + e);
            }
            try {
                // 3.付费用户数
                chargeNum = publicDao.queryChargeNum("eventcharge_" + sufTbName, platformId);
            } catch (Exception e) {
                System.out.println("SQL查询异常：" + e);
            }

            // 设值
            analysisPay.setRegNum(register != null ? register : 0);
            analysisPay.setNewPayNum(newChargeNum);
            analysisPay.setRegPaySum(newCharge);
            analysisPay.setPayTotal(chargeSum != null ? chargeSum : 0);
            analysisPay.setDau(dau != null ? dau : 0);
            analysisPay.setPayNum(chargeNum != null ? chargeNum : 0);
            // 4.付费渗透率 充值玩家/活跃玩家
            analysisPay.setPayRate(dau != 0 ? df.format((float) chargeNum * 100 / dau) : "0.00");
            // 5.总付费用户ARPU值 当天的总收入/当天的付费用户总数
            analysisPay.setPayNumArpu(chargeNum != 0 ? df.format((float) chargeSum / chargeNum) : "0.00");
            // 5.新用户付费率 新进用户的付费人数/新增用户数*100%
            analysisPay.setNewPayRate(register != 0 ? df.format((float) newChargeNum * 100 / register) : "0.00");
            // 6.新付费用户ARPU值 新用户当日的充值金额/新用户付费人数
            analysisPay.setNewNumArpu(newChargeNum != 0 ? df.format((float) newCharge / newChargeNum) : "0.00");
            // 6.活跃用户ARPU值 当天的总收入/DAU
            arppu = dau != 0 ? df.format((float) chargeSum / dau) : "0.00";
            analysisPay.setDauNumArpu(arppu);
            // 7.新增活跃用户ARPU值 当天新注册的用户总付费数/当天的新增用户数
            analysisPay.setNewDauNumArpu(register != 0 ? df.format((float) newCharge / register) : "0.00");
            // 8.设置渠道id
            analysisPay.setPlatformId(platformId);

            analysisPays.add(analysisPay);

        }

        return analysisPays;

    }


    //新进数据
    public List<TwoHourReg> queryHourPeopleNum(String searchDate, Integer platformId) {
        String startTime = DateUtil.getDays(7).get("begTime");
        String endTime = DateUtil.getDays(1).get("endTime");
        if (searchDate != null) {
            startTime = searchDate.subSequence(0, 10) + "  0:00:00";
            endTime = searchDate.subSequence(13, 23) + "  23:59:59";
        }

        List<String> dateList = DateUtil.getBetweenDate(startTime, endTime);
        List<TwoHourReg> regList = new ArrayList<>();

        for (int i = dateList.size() - 1; i >= 0; i--) {
            String tbName = "eventregister_" + dateList.get(i).replace("-", "");
            try {
                TwoHourReg queryHourPeopleNum = queryHourPeoUtil(dateList.get(i), tbName, DateUtil.strToStamp(dateList.get(i) + " 0:00:00"), DateUtil.strToStamp(dateList.get(i) + " 23:59:59"), platformId);
                regList.add(queryHourPeopleNum);
            } catch (Exception e) {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
        }


        return regList;
    }


    public TwoHourReg queryHourPeoUtil(String queryDate, String tbName, Integer begTime, Integer endTime, Integer platformId) {
        List<RegistByHour> HourPeopleNum = operationsDao.queryRegistByHour(tbName, begTime, endTime, platformId);
        //声明12长度的数组  存放每2小时登陆的个数赋初值各为0
        int s[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < HourPeopleNum.size(); i++) {
            if (HourPeopleNum.get(i).getHourNum() == 0) {
                s[0] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 1) {
                s[0] = s[0] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 2) {
                s[1] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 3) {
                s[1] = s[1] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 4) {
                s[2] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 5) {
                s[2] = s[2] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 6) {
                s[3] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 7) {
                s[3] = s[3] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 8) {
                s[4] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 9) {
                s[4] = s[4] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 10) {
                s[5] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 11) {
                s[5] = s[5] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 12) {
                s[6] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 13) {
                s[6] = s[6] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 14) {
                s[7] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 15) {
                s[7] = s[7] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 16) {
                s[8] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 17) {
                s[8] = s[8] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 18) {
                s[9] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 19) {
                s[9] = s[9] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 20) {
                s[10] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 21) {
                s[10] = s[10] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 22) {
                s[11] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 23) {
                s[11] = s[11] + HourPeopleNum.get(i).getPeopleNum();
            }

        }

        //构造实体类
        Integer peopleNum = s[0] + s[1] + s[2] + s[3] + s[4] + s[5] + s[6] + s[7] + s[8] + s[9] + s[10] + s[11];
        TwoHourReg taTime = new TwoHourReg(queryDate, peopleNum, s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9], s[10], s[11], platformId);

        return taTime;
    }

    /**
     * 实时在线人数
     *
     * @return
     */
    public List<OnlineInfo> queryOnlineInfo() {
        List<OnlineInfo> resultList = new ArrayList<>();
        //总数
        OnlineInfo onlineInfoSum = new OnlineInfo();
        Integer onlineSum = 0;

        List<OnlineInfo> onlineInfos = operationsDao.queryOnlineInfo();
        try {

            Integer times = onlineInfos.get(0).getTimeStamp();
            for (int i = 0; i < onlineInfos.size(); i++) {
                if (times.equals(onlineInfos.get(i).getTimeStamp())) {
                    onlineSum += onlineInfos.get(i).getNum();
                    onlineInfos.get(i).setOpenPlatTypeName(UserUtil.getPlatformName(onlineInfos.get(i).getOpenPlatType()));
                    resultList.add(onlineInfos.get(i));
                }
            }
            //总数
            onlineInfoSum.setNum(onlineSum);
            onlineInfoSum.setOpenPlatTypeName("总人数");
            resultList.add(0, onlineInfoSum);
        } catch (Exception e) {
            System.out.println("在线人数：无数据！" + e.getMessage());
        }

        return resultList;
    }


    /**
     * 商城购买
     *
     * @param searchDate
     * @param platformId
     * @return
     */
    public List<Shopping> queryShopping(String searchDate, Integer platformId, Integer currencyType) {
        //格式化标题
        Map<String, String> map = ReadExcel.readXlsmToMap("config/Item.xlsm", "Item", 9, 1, 3);
        Map<String, String> saleItemMap = ReadExcel.readXlsmToMap("config/Item.xlsm", "SaleItem", 9, 4, 2);
        map.putAll(saleItemMap);
        map.put("40004", "金属块*30");
        map.put("40005", "炭纤维*30");
        map.put("40006", "水晶体*30");
        map.put("40007", "金属块*50");
        map.put("40008", "炭纤维*50");
        map.put("40009", "水晶体*50");
        map.put("40050", "强化材料");
        map.put("40051", "强化材料");
        map.put("40052", "强化材料");
        map.put("40053", "突破1001");
        map.put("40054", "突破1002");
        map.put("40055", "突破1003");


        //默认查询昨天
        String begDay = DateUtil.getPastDate(1) + " 0:00:00";
        String endDay = DateUtil.getPastDate(1) + " 23:59:59";
        List<Shopping> shopping = new ArrayList<>();

        if (null != searchDate) {
            begDay = searchDate.subSequence(0, 10) + " 0:00:00";
            endDay = searchDate.subSequence(13, 23) + " 23:59:59";

        }
        String tbName = ("eventshopping_" + begDay.subSequence(0, 10)).replace("-", "");
        try {
            shopping = operationsDao.queryShopping(tbName, DateUtil.strToStamp(begDay), DateUtil.strToStamp(endDay), platformId, currencyType);
            for (int i = 0; i < shopping.size(); i++) {
                if (shopping.get(i).getGoodId() != null) {
                    shopping.get(i).setGoodName(map.get(String.valueOf(shopping.get(i).getGoodId())));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return shopping;
    }

    public List<DirectBuy> queryStoreBuy(String searchDate, Integer platformId) throws IOException {
        //默认查询昨天
        String begDay = DateUtil.getPastDate(0) + " 0:00:00";
        String endDay = DateUtil.getPastDate(0) + " 23:59:59";
        //获取道具名和单价
        Map<String, String> nameMap = ReadExcel.readXlsmToMap("config/Item.xlsm", "SaleLimitItem", 9, 1, 2);
        Map<String, String> nameMap2 = ReadExcel.readXlsmToMap("config/Item.xlsm", "SaleItem", 9, 1, 2);
        nameMap.putAll(nameMap2);

        Map<String, String> priceMap = ReadExcel.readXlsmToMap("config/Item.xlsm", "SaleLimitItem", 9, 1, 6);
        Map<String, String> priceMap2 = ReadExcel.readXlsmToMap("config/Item.xlsm", "SaleItem", 9, 1, 6);
        priceMap.putAll(priceMap2);

        List<DirectBuy> directBuys = new ArrayList<>();

        if (null != searchDate) {
            begDay = searchDate.subSequence(0, 10) + " 0:00:00";
            endDay = searchDate.subSequence(13, 23) + " 23:59:59";
        }
        try {
            String tbName = ("eventcharge_" + begDay.subSequence(0, 10)).replace("-", "");
            directBuys = operationsDao.queryStoreBuy(tbName, DateUtil.strToStamp(begDay), DateUtil.strToStamp(endDay), platformId);

            for (int i = 0; i < directBuys.size(); i++) {
                if (null != directBuys.get(i)) {
                    directBuys.get(i).setItemName(nameMap.get(String.valueOf(directBuys.get(i).getItemId())));
                    directBuys.get(i).setItemPrice(Integer.parseInt(priceMap.get(String.valueOf(directBuys.get(i).getItemId()))));
                    directBuys.get(i).setTotalMoney(directBuys.get(i).getBuyCount() * directBuys.get(i).getItemPrice());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return directBuys;
    }

    //玩家充值区间
    public List<UserChargeAll> queryFCharge(String searchDate, Integer platformId) {
        List<UserChargeAll> userChargeAlls = new ArrayList<>();
        Integer[] minMoneyArr = {0, 1000, 3000, 5000, 10000, 20000, 30000, 50000};
        Integer[] maxMoneyArr = {999, 2999, 4999, 9999, 19999, 29999, 49999, 999999999};

        //默认查询最近7天
        List<String> betweenDate = DateUtil.getLastSevenDay(0, 7);
        if (searchDate != null) {
            String begDay = (String) searchDate.subSequence(0, 10);
            String endDay = (String) searchDate.subSequence(13, 23);
            betweenDate = DateUtil.getBetweenDate(begDay, endDay);
            Collections.reverse(betweenDate);
        }
        for (int i = 0; i < betweenDate.size(); i++) {
            UserChargeAll userChargeAll = new UserChargeAll();
            List<Plann> plannList = new ArrayList<>();
            String tbName = "eventcharge_" + betweenDate.get(i).replace("-", "");
            try {
                //查询不同区间8次
                for (int j = 0; j < 8; j++) {
                    Plann plann = operationsDao.queryChargeSumOrCount(tbName, minMoneyArr[j], maxMoneyArr[j], platformId);
                    plannList.add(plann);
                }
                userChargeAll.setDateStamp(betweenDate.get(i));
                userChargeAll.setSumMoney10Num(plannList.get(0).getLevelId());
                userChargeAll.setSumMoney10(plannList.get(0).getUserNum());
                userChargeAll.setSumMoney30Num(plannList.get(1).getLevelId());
                userChargeAll.setSumMoney30(plannList.get(1).getUserNum());
                userChargeAll.setSumMoney50Num(plannList.get(2).getLevelId());
                userChargeAll.setSumMoney50(plannList.get(2).getUserNum());
                userChargeAll.setSumMoney100Num(plannList.get(3).getLevelId());
                userChargeAll.setSumMoney100(plannList.get(3).getUserNum());
                userChargeAll.setSumMoney200Num(plannList.get(4).getLevelId());
                userChargeAll.setSumMoney200(plannList.get(4).getUserNum());
                userChargeAll.setSumMoney300Num(plannList.get(5).getLevelId());
                userChargeAll.setSumMoney300(plannList.get(5).getUserNum());
                userChargeAll.setSumMoney500Num(plannList.get(6).getLevelId());
                userChargeAll.setSumMoney500(plannList.get(6).getUserNum());
                userChargeAll.setSumTop500Num(plannList.get(7).getLevelId());
                userChargeAll.setSumTop500(plannList.get(7).getUserNum());
                //5.充值金额
                Integer chargeSum = publicDao.queryCharge("eventcharge_" + betweenDate.get(i).replace("-", ""), platformId);
                userChargeAll.setSumMoney20Num(chargeSum==null?0:chargeSum);

                userChargeAlls.add(userChargeAll);

            } catch (Exception e) {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
        }

        return userChargeAlls;
    }

    //玩家充值区间
    public List<UserChargeAll> queryFCharge02(String searchDate, Integer platformId) {
        List<UserChargeAll> userChargeAlls = new ArrayList<>();
        List<UserCharge> chargeNumList = new ArrayList<>();
        List<UserCharge> chargeCountList = new ArrayList<>();
        //默认查询最近7天
        List<String> betweenDate = DateUtil.getLastSevenDay(0, 7);
        if (searchDate != null) {
            String begDay = (String) searchDate.subSequence(0, 10);
            String endDay = (String) searchDate.subSequence(13, 23);
            betweenDate = DateUtil.getBetweenDate(begDay, endDay);
        }
        for (int i = 0; i < betweenDate.size(); i++) {
            String tbName = "eventcharge_" + betweenDate.get(i).replace("-", "");
            try {
                UserCharge chargeNum = operationsDao.queryChargeNum(tbName, platformId);
                chargeNum.setDateStamp(betweenDate.get(i));
                UserCharge chargeCount = operationsDao.queryChargeCount(tbName, platformId);
                chargeNumList.add(chargeNum);
                chargeCountList.add(chargeCount);
            } catch (Exception e) {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
        }

        for (int i = 0; i < chargeNumList.size(); i++) {
            UserChargeAll userChargeAll = new UserChargeAll();
            userChargeAll.setDateStamp(chargeNumList.get(i).getDateStamp());
            userChargeAll.setSumMoney10Num(chargeNumList.get(i).getSumMoney10());
            userChargeAll.setSumMoney10(chargeCountList.get(i).getSumMoney10());
            userChargeAll.setSumMoney20Num(chargeNumList.get(i).getSumMoney20());
            userChargeAll.setSumMoney20(chargeCountList.get(i).getSumMoney20());
            userChargeAll.setSumMoney30Num(chargeNumList.get(i).getSumMoney30());
            userChargeAll.setSumMoney30(chargeCountList.get(i).getSumMoney30());
            userChargeAll.setSumMoney50Num(chargeNumList.get(i).getSumMoney50());
            userChargeAll.setSumMoney50(chargeCountList.get(i).getSumMoney50());
            userChargeAll.setSumMoney100Num(chargeNumList.get(i).getSumMoney100());
            userChargeAll.setSumMoney100(chargeCountList.get(i).getSumMoney100());
            userChargeAll.setSumMoney200Num(chargeNumList.get(i).getSumMoney200());
            userChargeAll.setSumMoney200(chargeCountList.get(i).getSumMoney200());
            userChargeAll.setSumMoney300Num(chargeNumList.get(i).getSumMoney300());
            userChargeAll.setSumMoney300(chargeCountList.get(i).getSumMoney300());
            userChargeAll.setSumMoney500Num(chargeNumList.get(i).getSumMoney500());
            userChargeAll.setSumMoney500(chargeCountList.get(i).getSumMoney500());
            userChargeAll.setSumTop500Num(chargeNumList.get(i).getSumTop500());
            userChargeAll.setSumTop500(chargeCountList.get(i).getSumTop500());

            userChargeAlls.add(userChargeAll);
        }


        return userChargeAlls;
    }


    /**
     * 玩家充值(首冲)
     *
     * @param searchDate
     * @param platformId
     * @return
     */
    public List<FirstCharge> queryFCharge01(String searchDate, Integer platformId) {
        List<FirstCharge> list = new ArrayList<FirstCharge>();
        //默认查询最近7天
        List<String> betweenDate = DateUtil.getLastSevenDay(0, 7);
        if (searchDate != null) {
            String begDay = (String) searchDate.subSequence(0, 10);
            String endDay = (String) searchDate.subSequence(13, 23);
            betweenDate = DateUtil.getBetweenDate(begDay, endDay);
        }

        for (int i = 0; i < betweenDate.size(); i++) {
            String tbName = "eventcharge_" + betweenDate.get(i).replace("-", "");
            FirstCharge firstCharge = new FirstCharge();
            try {
                firstCharge = queryFChargeUtil(tbName, betweenDate.get(i), platformId);
                //计算当天的充值金额
                Integer sumCharge = firstCharge.getChargeSixCount() * 6 + firstCharge.getChargeTwelveCount() * 12 + firstCharge.getChargeTwentyFiveCount() * 25 + firstCharge.getChargeThirtyCount() * 30 + firstCharge.getChargeSixtyEightCount() * 68 + firstCharge.getChargeNinetyEightCount() * 98 + firstCharge.getChargeHundredNECount() * 198 + firstCharge.getChargeThreeHTECount() * 328 + firstCharge.getChargeSixHFECount() * 648;
                //查询当天总的充值金额
                Integer chargeSums = publicDao.queryCharge(tbName, platformId);
                firstCharge.setChargeSum(sumCharge);
                firstCharge.setChargeSums(chargeSums / 100);
            } catch (Exception e) {
                System.out.println("异常:" + e.getMessage());
            }


            list.add(firstCharge);
        }

        return list;
    }

    //查询指定某天数据
    public FirstCharge queryFChargeUtil(String tbName, String searchDate, Integer platformId) {
        String begDay = searchDate + " 0:00:00";
        String endDay = searchDate + " 23:59:59";
        //定义查询的充值元数
        Integer[] money = {6, 12, 25, 30, 68, 98, 198, 328, 648};
        //接收查询结果的临时FirstCharge 对象
        FirstCharge tempList;
        //把查询结果中的有用值存入list
        List<Integer> templi = new ArrayList<>();
        //把结果循环赋值给 res 返回
        FirstCharge res = new FirstCharge();
        //设置日期参数
        res.setMyDate(searchDate);
        try {
            for (int i = 0; i < money.length; i++) {
                try {
                    tempList = operationsDao.queryFCharge(tbName, DateUtil.strToStamp(begDay), DateUtil.strToStamp(endDay), money[i] * 100, platformId);
                    templi.add(tempList.getChargeSix());
                    templi.add(tempList.getChargeSixCount());
                } catch (Exception e) {
                    System.out.println("SQL查询异常：" + e.getMessage());
                }
            }
            res.setChargeSix(templi.get(0));
            res.setChargeSixCount(templi.get(1));
            res.setChargeTwelve(templi.get(2));
            res.setChargeTwelveCount(templi.get(3));
            res.setChargeTwentyFive(templi.get(4));
            res.setChargeTwentyFiveCount(templi.get(5));
            res.setChargeThirty(templi.get(6));
            res.setChargeThirtyCount(templi.get(7));
            res.setChargeSixtyEight(templi.get(8));
            res.setChargeSixtyEightCount(templi.get(9));
            res.setChargeNinetyEight(templi.get(10));
            res.setChargeNinetyEightCount(templi.get(11));
            res.setChargeHundredNE(templi.get(12));
            res.setChargeHundredNECount(templi.get(13));
            res.setChargeThreeHTE(templi.get(14));
            res.setChargeThreeHTECount(templi.get(15));
            res.setChargeSixHFE(templi.get(16));
            res.setChargeSixHFECount(templi.get(17));
        } catch (Exception e) {
            System.out.println("SQL查询异常：" + e.getMessage());
        }


        return res;
    }


    //钻石统计
    public List<Diamond> queryDiamond(String searchDate, Integer platformId) {
        List<Diamond> diamondList = new ArrayList<>();
        //默认查询最近7天
        List<String> betweenDate = DateUtil.getLastSevenDay(0, 7);
        if (searchDate != null) {
            String begDay = (String) searchDate.subSequence(0, 10);
            String endDay = (String) searchDate.subSequence(13, 23);
            betweenDate = DateUtil.getBetweenDate(begDay, endDay);
            Collections.reverse(betweenDate);
        }

        for (int i = 0; i < betweenDate.size(); i++) {
            String tbName = "eventdiamondflow_" + betweenDate.get(i).replace("-", "");
            Diamond diamond = new Diamond();
            diamond.setMyDate(betweenDate.get(i));
            //0.获取dau
            Integer dau = 0;
            try {
                dau = publicDao.queryDau("eventlogin_" + betweenDate.get(i).replace("-", ""), platformId);
            } catch (Exception e) {
                System.out.println("异常:" + e.getMessage());
            }

            //1.钻石增量
            long addSum = 0;
            long welfareSum = 0;
            long chargeSum = 0;
            try {
                List<Plann> plannList = operationsDao.queryDiamondAdd(tbName, platformId);
                for (int j = 0; j < plannList.size(); j++) {
                    //1)获取钻石总增量
                    addSum += plannList.get(j).getUserNum();

                    //2)获取福利产生钻石量6,7,11,16,18,19,23
                    if (plannList.get(j).getLevelId() == 6 || plannList.get(j).getLevelId() == 7 || plannList.get(j).getLevelId() == 11 || plannList.get(j).getLevelId() == 16 || plannList.get(j).getLevelId() == 18 || plannList.get(j).getLevelId() == 19 || plannList.get(j).getLevelId() == 23) {
                        welfareSum += plannList.get(j).getUserNum();
                    }

                    //3)充值产出钻石量 20
                    if (plannList.get(j).getLevelId() == 20) {
                        chargeSum = plannList.get(j).getUserNum();
                    }
                }
            } catch (Exception e) {
                System.out.println("异常:" + e.getMessage());
            }
            diamond.setAddSum(addSum);
            diamond.setWelfareSum(welfareSum);
            diamond.setChargeSum(chargeSum);
            //2.钻石消耗
            int diamondSub = 0;
            try {
                diamondSub = operationsDao.queryDiamondSub(tbName, platformId);
            } catch (Exception e) {
                System.out.println("异常:" + e.getMessage());
            }

            //4)钻石总消耗
            diamond.setSubSum(diamondSub);
            //5)人均福利钻石量
            diamond.setWelfareSumAvg(dau == 0 ? "0.00" : df.format((float) diamond.getWelfareSum() / dau));
            //6)人均钻石消耗
            diamond.setSubAvg(dau == 0 ? "0.00" : df.format((float) diamond.getSubSum() / dau));
            //7)人均钻石存量
            int afterCount = 0;
            try {
                afterCount = operationsDao.queryDiamondAfterCount(tbName, platformId);
            } catch (Exception e) {
                System.out.println("异常:" + e.getMessage());
            }
            diamond.setStorageAvg(dau == 0 ? "0.00" : df.format((float) afterCount / dau));
            diamondList.add(diamond);
        }

        return diamondList;
    }

    //金币统计
   /* public List<Diamond> queryGolds(String searchDate,Integer platformId)
    {
        //默认查询最近7天
        List<String> betweenDate = DateUtil.getLastSevenDay(0,7);
        if(searchDate != null)
        {
            String begDay=(String)searchDate.subSequence(0, 10);
            String endDay=(String)searchDate.subSequence(13, 23);
            betweenDate = DateUtil.getBetweenDate(begDay, endDay);
        }
        for(int i=0;i<betweenDate.size();i++)
        {
            Diamond diamond =new Diamond();
            String tbName="eventcoinflow_"+betweenDate.get(i).replace("-","" );
            try{
                //1.查询金币总增量和总消耗
                List<ItemFlow> addItems=operationsDao.ItemChangeSum(tbName, 1, platformId);
                List<ItemFlow> subItems=operationsDao.ItemChangeSum(tbName, 2, platformId);
                //2.查询dau
                Integer dau=publicDao.queryDau("eventlogin_"+betweenDate.get(i).replace("-","" ), platformId);
                //3.充值和福利产生金币
                long addSum=0;
                long welfareSum=0;
                long chargeSum=0;
                long subSum=0;
                long subWelfareSum=0;
                long subChargeSum=0;
                for(int j=0;j<addItems.size();j++)
                {
                    //1)充值产生(reason=20)
                    if(addItems.get(j).getReason()==20)
                    {
                        chargeSum=addItems.get(j).getItemSum();
                    }
                    //2)金币总增量(1000为GM产生,除GM生产)
                    if(addItems.get(j).getReason()!=1000)
                    {
                        addSum+=addItems.get(j).getItemSum();
                    }
                    //2)福利产生(除充值和GM外)
                    if(addItems.get(j).getReason()!=1000 && addItems.get(j).getReason()!=20)
                    {
                        welfareSum+=addItems.get(j).getItemSum();
                    }

                }
                for(int k=0;k<subItems.size();k++)
                {
                    //1)充值产生(reason=20)
                    if(subItems.get(k).getReason()==20)
                    {
                        subChargeSum=subItems.get(k).getItemSum();
                    }
                    //2)金币总增量(1000为GM产生,除GM生产)
                    if(subItems.get(k).getReason()!=1000)
                    {
                        subSum+=subItems.get(k).getItemSum();
                    }
                    //2)福利产生(除充值和GM外)
                    if(subItems.get(k).getReason()!=1000 && subItems.get(k).getReason()!=20)
                    {
                        subWelfareSum+=subItems.get(k).getItemSum();
                    }

                }

                //4.人均金币消耗
                diamond.setSubAvg(dau!=0?subSum/dau:0);
                //5.人均福利金币量
                diamond.setWelfareSumAvg(dau!=0?welfareSum/dau:0);

            }catch (Exception e)
            {
                System.out.println("SQL查询异常："+e.getMessage());
            }
        }

        return diamondList;
    }*/

    //钻石消耗途径分析
    public List<SubDiamond> subDiamond(String searchDate, Integer platformId) {
        List<SubDiamond> subDiamonds = new ArrayList<>();
        List<String> betweenDate = DateUtil.getLastSevenDay(0, 7);
        if (searchDate != null) {
            betweenDate = DateUtil.getBetweenDate(searchDate.subSequence(0, 10) + "", searchDate.subSequence(13, 23) + "");
        }
        for (int l = 0; l < betweenDate.size(); l++) {
            String tbName = "eventdiamondflow_" + betweenDate.get(l).replace("-", "");
            try {
                List<Plann> planns = operationsDao.subDiamond(tbName, DateUtil.strToStamp(betweenDate.get(l) + " 0:00:00"), DateUtil.strToStamp(betweenDate.get(l) + " 23:59:59"), platformId);
                SubDiamond subDiamond = new SubDiamond(betweenDate.get(l), 0, 0, 0, 0, 0, 0, 0, 0);
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
                //subDiamond.setCheckDate(betweenDate.get(l));
                subDiamond.setSubSum(-subSum);
                subDiamonds.add(subDiamond);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        }

        return subDiamonds;
    }

    //用户长期回本
    public List<Ltv> queryLtv(String searchDate, Integer platformId) {
        List<Ltv> ltvList = new ArrayList<>();
        //默认查询最近7天
        List<String> betweenDate = DateUtil.getLastSevenDay(0, 7);
        if (searchDate != null) {
            betweenDate = DateUtil.getBetweenDate(searchDate.subSequence(0, 10) + "", searchDate.subSequence(13, 23) + "");
        }
        for (int i = 0; i < betweenDate.size(); i++) {
            Ltv ltv = new Ltv();
            String checkDate = betweenDate.get(i).replace("-", "");
            String chargeTbName = "eventcharge_" + checkDate;
            Integer begTs = DateUtil.strToStamp(betweenDate.get(i) + " 0:00:00");
            Integer endTs = DateUtil.strToStamp(betweenDate.get(i) + " 23:59:59");
            //设置日期
            ltv.setMyDate(betweenDate.get(i));

            //1.新增玩家
            int registerNunm = 0;
            try {
                registerNunm = publicDao.queryRegister("eventregister_" + checkDate, platformId);
            } catch (Exception e) {
                System.out.println("SQL查询异常:" + e.getMessage());
            }
            ltv.setRegNum(registerNunm);
            //3.累计充值金额：首日~7日 14日  30日 60日
            //获取当天到7,14,30,60天的日期集合
            List<String> betweenDate07 = DateUtil.getBetweenDate(betweenDate.get(i), DateUtil.getDateAfter(betweenDate.get(i), 6, "yyyy-MM-dd"));
            List<String> betweenDate14 = DateUtil.getBetweenDate(betweenDate.get(i), DateUtil.getDateAfter(betweenDate.get(i), 13, "yyyy-MM-dd"));
            List<String> betweenDate30 = DateUtil.getBetweenDate(betweenDate.get(i), DateUtil.getDateAfter(betweenDate.get(i), 29, "yyyy-MM-dd"));
            List<String> betweenDate60 = DateUtil.getBetweenDate(betweenDate.get(i), DateUtil.getDateAfter(betweenDate.get(i), 59, "yyyy-MM-dd"));
            //1)获取首日总充值金额
            int  tempCharge = 0;
            int chargeDate01 = 0;
            try {
                chargeDate01 = operationsDao.queryChargesSum(chargeTbName, begTs, endTs, platformId);
            } catch (Exception e) {
                System.out.println("SQL查询异常:" + e.getMessage());
            }
            ltv.setChargeSum01(chargeDate01);

            //新增--7日内
            int chargeDate02 = chargeDate01;
            try {
                tempCharge = operationsDao.queryChargesSum("eventcharge_" + betweenDate07.get(1).replace("-", ""), begTs, endTs, platformId);
                chargeDate02 += tempCharge ;
            } catch (Exception e) {
                System.out.println("SQL查询异常:" + e.getMessage());
            }
            ltv.setChargeSum02(chargeDate02);

            int chargeDate03 = chargeDate02;
            try {
                tempCharge = operationsDao.queryChargesSum("eventcharge_" + betweenDate07.get(2).replace("-", ""), begTs, endTs, platformId);
                chargeDate03 += tempCharge;
                } catch (Exception e) {
                System.out.println("SQL查询异常:" + e.getMessage());
            }
            ltv.setChargeSum03(chargeDate03);

            int chargeDate04 = chargeDate03;
            try {
                tempCharge = operationsDao.queryChargesSum("eventcharge_" + betweenDate07.get(3).replace("-", ""), begTs, endTs, platformId);
                chargeDate04 += tempCharge;
            } catch (Exception e) {
                System.out.println("SQL查询异常:" + e.getMessage());
            }
            ltv.setChargeSum04(chargeDate04);

            int chargeDate05 = chargeDate04;
            try {
                tempCharge = operationsDao.queryChargesSum("eventcharge_" + betweenDate07.get(4).replace("-", ""), begTs, endTs, platformId);
                chargeDate05 += tempCharge;
            } catch (Exception e) {
                System.out.println("SQL查询异常:" + e.getMessage());
            }
            ltv.setChargeSum05(chargeDate05);

            int chargeDate06 = chargeDate05;
            try {
                tempCharge = operationsDao.queryChargesSum("eventcharge_" + betweenDate07.get(5).replace("-", ""), begTs, endTs, platformId);
                chargeDate06 += tempCharge;
            } catch (Exception e) {
                System.out.println("SQL查询异常:" + e.getMessage());
            }
            ltv.setChargeSum06(chargeDate06);

            int chargeDate07 = chargeDate06;
            try {
                tempCharge = operationsDao.queryChargesSum("eventcharge_" + betweenDate07.get(6).replace("-", ""), begTs, endTs, platformId);
                chargeDate07 += tempCharge;
            } catch (Exception e) {
                System.out.println("SQL查询异常:" + e.getMessage());
            }
            ltv.setChargeSum07(chargeDate07);

            //3)获取14日总充值金额
            int chargeDate14 = chargeDate07;
            for (int j = 7; j < betweenDate14.size(); j++) {
                int chargeDate = 0;
                try {
                    chargeDate = operationsDao.queryChargesSum("eventcharge_" + betweenDate14.get(j).replace("-", ""), begTs, endTs, platformId);
                    chargeDate14 += chargeDate;
                } catch (Exception e) {
                    System.out.println("SQL查询异常:" + e.getMessage());
                }

            }
            ltv.setChargeSum14(chargeDate14);

            //4)获取30日总充值金额
            int chargeDate30 = chargeDate14;
            for (int j = 14; j < betweenDate30.size(); j++) {
                int chargeDate = 0;
                try {
                    chargeDate = operationsDao.queryChargesSum("eventcharge_" + betweenDate30.get(j).replace("-", ""), begTs, endTs, platformId);
                    chargeDate30 += chargeDate;
                } catch (Exception e) {
                    System.out.println("SQL查询异常:" + e.getMessage());
                }

            }
            ltv.setChargeSum30(chargeDate30);

            //5)获取60日总充值金额
            int chargeDate60 = chargeDate30;
            for (int j = 30; j < betweenDate60.size(); j++) {
                int chargeDate = 0;
                try {
                    chargeDate = operationsDao.queryChargesSum("eventcharge_" + betweenDate60.get(j).replace("-", ""), begTs, endTs, platformId);
                    chargeDate60 += chargeDate;
                } catch (Exception e) {
                    System.out.println("SQL查询异常:" + e.getMessage());
                }

            }
            ltv.setChargeSum60(chargeDate60);

            //4.LTV：  首日~7日 14日  30日 60日
            //1)获取首日LTV
            ltv.setLtv01(registerNunm == 0 ? "0" : df.format((float) chargeDate01 / registerNunm));
            //新增
            ltv.setLtv02(registerNunm == 0 ? "0" : df.format((float) chargeDate02 / registerNunm));
            ltv.setLtv03(registerNunm == 0 ? "0" : df.format((float) chargeDate03 / registerNunm));
            ltv.setLtv04(registerNunm == 0 ? "0" : df.format((float) chargeDate04 / registerNunm));
            ltv.setLtv05(registerNunm == 0 ? "0" : df.format((float) chargeDate05 / registerNunm));
            ltv.setLtv06(registerNunm == 0 ? "0" : df.format((float) chargeDate06 / registerNunm));
            //2)获取7日LTV
            ltv.setLtv07(registerNunm == 0 ? "0" : df.format((float) chargeDate07 / registerNunm));
            //3)获取14日LTV
            ltv.setLtv14(registerNunm == 0 ? "0" : df.format((float) chargeDate14 / registerNunm));
            //4)获取30日LTV
            ltv.setLtv30(registerNunm == 0 ? "0" : df.format((float) chargeDate30 / registerNunm));
            //5)获取60日LTV
            ltv.setLtv60(registerNunm == 0 ? "0" : df.format((float) chargeDate60 / registerNunm));

            ltvList.add(ltv);
        }


        return ltvList;
    }


    //金币统计(老版本)
    public List<Diamond> queryGold(String searchDate, Integer platformId) {
        String begDay = DateUtil.getPastDate(7);
        String endDay = DateUtil.getPastDate(1);
        String tbName = "myGold";
        List<Diamond> diamondList;
        if (platformId == null) {
            tbName = "myGolds";
        }
        //默认查询最近7天(不含今天)
        if (searchDate != null) {
            begDay = (String) searchDate.subSequence(0, 10);
            endDay = (String) searchDate.subSequence(13, 23);

        }
        diamondList = operationsDao.queryDiamond(begDay, endDay, tbName, platformId);

        return diamondList;
    }
}
