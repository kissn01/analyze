package com.yoooum.dao;

import com.yoooum.domain.LoserUser;
import com.yoooum.domain.Plann;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2020/2/11 10:51
 * @描述:
 */
public interface UtilDao
{
    //查询流失或留存用户的 失败关卡ID 地图id 和 战力
    List<LoserUser>  loserList(@Param("tbName") String tbName, @Param("uin") Integer uin);

    //批量查询指定uin 的闯关情况
    List<LoserUser> queryLoserByUin(@Param("tbName") String tbName, @Param("uinList") List<Integer> uinList);

    //批量查询指定uin 的战力情况
    List<LoserUser> queryFightByUins(@Param("tbName") String tbName, @Param("uinList") List<Integer> uinList);

    //批量查询指定uin 的战力情况
    LoserUser  queryFightByUin(@Param("tbName") String tbName, @Param("uin") Integer uin);

    //查询首次通关第七章或第八章玩家战力
    List<Plann> queryFightUsers(@Param("tbName") String tbName,@Param("chapterId") Integer chapterId);
}
