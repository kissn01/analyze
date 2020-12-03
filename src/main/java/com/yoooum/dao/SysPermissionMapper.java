package com.yoooum.dao;

import com.yoooum.domain.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/8/21 14:23
 * @描述:
 */
@Mapper
public interface SysPermissionMapper
{
    @Select("SELECT * FROM sys_permission WHERE role_id=#{roleId}")
    List<SysPermission> listByRoleId(Integer roleId);
}
