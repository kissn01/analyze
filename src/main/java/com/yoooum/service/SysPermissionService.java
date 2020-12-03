package com.yoooum.service;

import com.yoooum.dao.SysPermissionMapper;
import com.yoooum.domain.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/8/21 14:24
 * @描述:
 */
@Service
public class SysPermissionService
{
    @Autowired
    private SysPermissionMapper permissionMapper;

    /**
     * 获取指定角色所有权限
     */
    public List<SysPermission> listByRoleId(Integer roleId) {
        return permissionMapper.listByRoleId(roleId);
    }
}
