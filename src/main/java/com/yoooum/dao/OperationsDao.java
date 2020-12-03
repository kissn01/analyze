package com.yoooum.dao;

import com.yoooum.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/18 19:50
 * @描述:
 */
public interface OperationsDao
{
    //运营数据总览
    List<MyOperationData>  queryOperationData(@Param("begDay")String begDay,@Param("endDay")String endDay,@Param("tbName")String tbName,@Param("platformId") Integer platformId);

    //用户付费解析
    List<MyOperationData>  queryAnalysisPay(@Param("begDay")String begDay,@Param("endDay")String endDay,@Param("tbName")String tbName,@Param("platformId") Integer platformId);

    //用户留存
    List<MyUserRetention> queryRetention(@Param("begDay")String begDay,@Param("endDay")String endDay,@Param("tbName")String tbName,@Param("platformId") Integer platformId);

    //查询每个小时注册的人数
    List<RegistByHour> queryRegistByHour(@Param("tbName") String tbName,@Param("begTime") Integer begTime, @Param("endTime") Integer endTime, @Param("platformId") Integer platformId);

    //实时在线人数
    List<OnlineInfo> queryOnlineInfo();

    //商城购买统计
    List<Shopping> queryShopping(@Param("tbName") String tbName,@Param("begDay") Integer begDay, @Param("endDay") Integer endDay, @Param("platformId") Integer platformId,@Param("currencyType") Integer currencyType);

    //商城直购统计
    List<DirectBuy> queryStoreBuy(@Param("tbName") String tbName,@Param("begDay") Integer begDay, @Param("endDay") Integer endDay, @Param("platformId") Integer platformId);

    //查询充值情况
    FirstCharge queryFCharge(@Param("tbName") String tbName,@Param("begDay") Integer begDay, @Param("endDay") Integer endDay,@Param("money") Integer money, @Param("platformId") Integer platformId);

    //钻石查询
    List<Diamond> queryDiamond(@Param("begDay") String begDay, @Param("endDay") String endDay,@Param("tbName")String tbName,@Param("platformId") Integer platformId);

    //玩家钻石消耗途径分布
    List<Plann> subDiamond(@Param("tbName") String tbName,@Param("begDay") Integer begDay, @Param("endDay") Integer endDay,@Param("platformId") Integer platformId);

    //用户充值区间分布人数
    UserCharge queryChargeNum(@Param("tbName")String tbName,@Param("platformId") Integer platformId);

    //用户充值区间分布次数
    UserCharge queryChargeCount(@Param("tbName")String tbName,@Param("platformId") Integer platformId);

    //查询区间内人数和次数
    Plann  queryChargeSumOrCount(@Param("tbName")String tbName,@Param("minMoney")Integer minMoney,@Param("maxMoney")Integer maxMoney,@Param("platformId") Integer platformId);

    //LTV
    List<Ltv> queryLtv(@Param("tbName")String tbName,@Param("begTs") String begTs,@Param("endTs") String endTs,@Param("platformId") Integer platformId);

    //LTV --累计充值金额
    int queryChargesSum(@Param("tbName")String tbName,@Param("begTs") Integer begTs,@Param("endTs") Integer endTs,@Param("platformId") Integer platformId);

    //金币总增量或总消耗
    List<ItemFlow> ItemChangeSum(@Param("tbName")String tbName,@Param("type") Integer type,@Param("platformId") Integer platformId);


    //钻石总增量
    List<Plann> queryDiamondAdd(@Param("tbName")String tbName,@Param("platformId") Integer platformId);

    //钻石总消耗
    int queryDiamondSub(@Param("tbName")String tbName,@Param("platformId") Integer platformId);

    //人均钻石存量
    int queryDiamondAfterCount(@Param("tbName")String tbName,@Param("platformId") Integer platformId);

}
