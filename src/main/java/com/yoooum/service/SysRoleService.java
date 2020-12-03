package com.yoooum.service;

import com.yoooum.dao.SysRoleMapper;
import com.yoooum.domain.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @创建人: ${kiss}
 * @时间: 2019/8/20 20:24
 * @描述:
 */
@Service
public class SysRoleService
{
    @Autowired
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id){
        return roleMapper.selectById(id);
    }

    public SysRole selectByName(String roleName){return roleMapper.selectByName(roleName); }
}
