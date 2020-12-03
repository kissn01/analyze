package com.yoooum.dao;

import com.yoooum.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/25 11:26
 * @描述:
 */
public interface PlannDao
{
    //关卡通关情况分布
    List<Plann> queryPlann(@Param("tbName") String tbName,@Param("begRegTs") Integer begRegTs, @Param("endRegTs") Integer endRegTs, @Param("platformId") Integer platformId,@Param("checkId") Integer checkId);

    //关卡通关分析
    List<PassCustoms> queryPassCustoms(@Param("begDay") String begDay, @Param("endDay") String endDay, @Param("platformId") Integer platformId,@Param("checkId") Integer checkId);

    //关卡开启区间分布
    PlanOpenCount queryPConsume(@Param("begDay") String begDay, @Param("endDay") String endDay, @Param("platformId") Integer platformId,@Param("checkId") Integer checkId);

    //主线人数
    Integer mainPerson(@Param("tbName") String tbName,@Param("platformId") Integer platformId);

    //各副本挑战人数
    List<FightHero> planPerson(@Param("tbName") String tbName,  @Param("platformId") Integer platformId);

    //金币和材料
    ItemSection itemSection(@Param("tbName") String tbName,@Param("checkType") Integer checkType,  @Param("platformId") Integer platformId);

    //新手关卡通过情况
    List<FightHero> queryNewPlay(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

}
