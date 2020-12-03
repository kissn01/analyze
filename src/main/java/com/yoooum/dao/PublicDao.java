package com.yoooum.dao;


import com.yoooum.domain.Fight;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/11/29 16:36
 * @描述:
 */
public interface PublicDao
{
    //活跃玩家DAU
    Integer queryDau(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    //新增玩家
    Integer queryRegister(@Param("tbName") String tbName,@Param("platformId") Integer platformId);

    //当天充值总金额
    Integer queryCharge(@Param("tbName") String tbName,@Param("platformId") Integer platformId);

    //充值玩家数量
    Integer queryChargeNum(@Param("tbName") String tbName,@Param("platformId") Integer platformId);

    //新增玩家充值人数=充值人数中注册时间在指定日期的~
    int queryChargeNumByReg(@Param("tbName") String tbName,@Param("begTime") Integer begTime,@Param("endTime")Integer endTime,@Param("platformId") Integer platformId);

    //新增玩家充值总金额
    int queryNewCharge(@Param("tbName") String tbName,@Param("begTime") Integer begTime,@Param("endTime")Integer endTime,@Param("platformId") Integer platformId);

    //新增玩家uin
    List<Integer> queryRegUin(@Param("tbName") String tbName,@Param("platformId") Integer platformId);

    //活跃玩家uin
    List<Integer> queryLoginUin(@Param("tbName") String tbName,@Param("platformId") Integer platformId);

    //查询指定uin 的闯关情况
    List<Fight> queryFightByUin(@Param("tbName") String tbName, @Param("uinList") List<Integer> uinList);
}
