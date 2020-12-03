package com.yoooum.service;

import com.yoooum.dao.SysUserRoleMapper;
import com.yoooum.domain.SysUserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/8/20 20:25
 * @描述:
 */
@Service
public class SysUserRoleService
{
    @Resource
    private SysUserRoleMapper userRoleMapper;

    public List<SysUserRole> listByUserId(Integer userId)
    {
        List<SysUserRole> list = userRoleMapper.listByUserId(userId);
        return list;
    }
}

