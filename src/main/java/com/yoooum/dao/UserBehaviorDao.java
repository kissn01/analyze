package com.yoooum.dao;

import com.yoooum.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/25 21:21
 * @描述:
 */
public interface UserBehaviorDao
{
    //在线时长分布
    GameTimeSection queryGameTime(@Param("tbName") String tbName,@Param("begRegTs") Integer begRegTs,@Param("endRegTs") Integer endRegTs,@Param("platformId") Integer platformId,@Param("checkId")Integer checkId);

    //指定玩家最高关卡
    UserInfo queryMaxLev(@Param("tbName") String tbName, @Param("uin") Integer uin,@Param("osType")Integer osType,@Param("zoneId")Integer zoneId);

    //指定玩家当日体力消耗
    Integer queryManual(@Param("tbName") String tbName,@Param("uin") Integer uin,@Param("osType")Integer osType,@Param("zoneId")Integer zoneId);

    //指定玩家当天的在线时长和最终等级
    UserInfo queryOnlineTime(@Param("tbName") String tbName,@Param("uin") Integer uin,@Param("osType")Integer osType,@Param("zoneId")Integer zoneId);

    //指定玩家当天的充值金额
    Integer queryCharge(@Param("tbName") String tbName,  @Param("uin") Integer uin,@Param("osType")Integer osType,@Param("zoneId")Integer zoneId);

    //查询每个英雄出战次数
    List<FightHero> queryFightHero(@Param("tbName") String tbName,@Param("begRegTs") Integer begRegTs, @Param("endRegTs") Integer endRegTs,@Param("platformId")Integer platformId,@Param("checkId")Integer checkId);
    //查询英雄出战总次数+dau
    FightHero queryFightSum(@Param("tbName") String tbName,@Param("begRegTs") Integer begRegTs, @Param("endRegTs") Integer endRegTs,@Param("platformId")Integer platformId,@Param("checkId")Integer checkId);

    //查询某个关卡每个英雄出战次数
    List<FightHero> queryPlannHero(@Param("tbName") String tbName,@Param("begRegTs") Integer begRegTs, @Param("endRegTs") Integer endRegTs,@Param("platformId")Integer platformId,@Param("begChapterId")Integer begChapterId,@Param("endChapterId")Integer endChapterId,@Param("checkId")Integer checkId);

    //玩家等级分布
    List<UserLevel> queryUserLevel(@Param("tbName") String tbName,@Param("begRegTs") Integer begRegTs, @Param("endRegTs") Integer endRegTs,@Param("platformId")Integer platformId,@Param("checkId")Integer checkId);

    //留存用户等级成长跟踪
    List<Plann> queryLevel(@Param("tbName") String tbName,@Param("begDay") Integer begDay, @Param("endDay") Integer endDay,@Param("regBegDay") Integer regBegDay, @Param("regEndDay") Integer regEndDay, @Param("platformId") Integer platformId);

    //玩家道具查询
    List<UserItemFlow> queryItemFlow(@Param("tbName") String tbName,@Param("zoneId") Integer zoneId,@Param("uin") Integer uin);

    //玩家充值查询
    List<EventCharge> queryUserCharge(@Param("tbName") String tbName,@Param("uin") Integer uin);
}
