package com.yoooum.service;

import com.yoooum.dao.SysUserMapper;
import com.yoooum.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @创建人: ${kiss}
 * @时间: 2019/8/20 20:24
 * @描述:
 */
@Service
public class SysUserService
{
    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }
}
