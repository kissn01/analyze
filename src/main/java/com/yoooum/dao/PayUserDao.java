package com.yoooum.dao;

import com.yoooum.domain.Natural;
import com.yoooum.domain.Plann;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2020/2/4 15:56
 * @描述: 付费用户
 */
public interface PayUserDao
{
    //当天付费玩家个数
    Integer queryPayUser(@Param("tbName") String tbName,@Param("platformId") Integer platformId);

    //获取付费用户uin
    List<Integer> getUinList(@Param("tbName") String tbName,@Param("platformId") Integer platformId);

    //获取付费用户等级
    Integer queryUserLevel(@Param("tbName") String tbName,@Param("uin") Integer uin);

    //获取付费用户等级
    Integer queryUserPass(@Param("tbName") String tbName,@Param("uin") Integer uin);

    //批量获取付费用户钻石消耗
    List<Plann>  queryPayDiamod(@Param("tbName") String tbName, @Param("uinList") List<Integer> uinList);

    //批量获取付费用户遗物抽取情况
    List<Natural> queryPayNatural(@Param("tbName") String tbName,@Param("chapterId") Integer chapterId,@Param("uinList") List<Integer> uinList);

}
