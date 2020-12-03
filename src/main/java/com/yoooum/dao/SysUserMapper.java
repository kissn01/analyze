package com.yoooum.dao;

import com.yoooum.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @创建人: ${kiss}
 * @时间: 2019/8/20 20:22
 * @描述:
 */
@Mapper
public interface  SysUserMapper
{
    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    SysUser selectById(Integer id);

    @Select("SELECT * FROM sys_user WHERE name = #{name}")
    SysUser selectByName(String name);
}
