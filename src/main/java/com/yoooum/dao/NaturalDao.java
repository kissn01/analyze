package com.yoooum.dao;

import com.yoooum.domain.FightHero;
import com.yoooum.domain.Natural;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/11/29 14:23
 * @描述: 遗物总览
 */
public interface NaturalDao
{
    //玩家遗物抽取情况总览
    List<Natural> lottery(@Param("tbName")String tbName,@Param("begRegTs")Integer begRegTs, @Param("endRegTs")Integer endRegTs, @Param("checkId")Integer checkId, @Param("chapterId") Integer chapterId, @Param("platformId") Integer platformId);

    //玩家持有遗物详情
    //1.遗物战力加成
    Integer maxCommonFight(@Param("tbName")String tbName,@Param("uin")String uin);
    //2.获取遗物id 和等级
    List<FightHero>  getIdAndLv(@Param("tbName")String tbName,@Param("uin")String uin);
    //3.套装id和等级
    List<FightHero>  getIdAndLvSuit(@Param("tbName")String tbName,@Param("uin")String uin);

}
