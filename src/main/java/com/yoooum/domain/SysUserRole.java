package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2019/8/20 20:21
 * @描述:
 */
@Data
public class SysUserRole
{
    static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer roleId;
}
