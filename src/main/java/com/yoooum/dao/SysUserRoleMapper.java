package com.yoooum.dao;

import com.yoooum.domain.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/8/20 20:23
 * @描述:
 */
@Mapper
public interface SysUserRoleMapper
{
    @Select("SELECT * FROM sys_user_role WHERE user_id = #{userId}")
    List<SysUserRole> listByUserId(Integer userId);
}
