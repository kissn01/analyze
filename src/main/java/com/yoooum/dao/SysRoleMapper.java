package com.yoooum.dao;

import com.yoooum.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @创建人: ${kiss}
 * @时间: 2019/8/20 20:23
 * @描述:
 */
@Mapper
public interface SysRoleMapper
{
    @Select("SELECT * FROM sys_role WHERE id = #{id}")
    SysRole selectById(Integer id);

    @Select("SELECT * FROM sys_role WHERE name = #{roleName}")
    SysRole selectByName(String roleName);
}
