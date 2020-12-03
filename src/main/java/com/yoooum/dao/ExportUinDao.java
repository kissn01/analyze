package com.yoooum.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/25 21:21
 * @描述:
 */
public interface ExportUinDao
{

    //导出当日付费用户的uin
    List<Integer> exportChargeUin(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    //导出停留关卡用户的uin
    List<Integer> exportPlannUin(@Param("tbName") String tbName,@Param("begRegTs") Integer begRegTs, @Param("endRegTs") Integer endRegTs, @Param("levelId") Integer levelId, @Param("platformId") Integer platformId,@Param("checkId")Integer checkId);

    //导出每小时注册人数
    List<Integer> exportHourUin(@Param("tbName") String tbName,@Param("begDay") Integer begDay, @Param("endDay") Integer endDay, @Param("platformId") Integer platformId);

}
