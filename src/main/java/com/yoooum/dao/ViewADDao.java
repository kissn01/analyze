package com.yoooum.dao;

/**
 * @创建人: ${kiss}
 * @时间: 2019/12/4 11:41
 * @描述:
 */

import com.yoooum.domain.DialViewAD;
import com.yoooum.domain.FightHero;
import com.yoooum.domain.SkillViewAD;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 广告统计
 */
public interface ViewADDao
{
    List<FightHero> play(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    Integer  playNum(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    //SkillViewAD playSkill(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    DialViewAD dial(@Param("tbName") String tbName, @Param("platformId") Integer platformId,@Param("type") Integer type);
}
