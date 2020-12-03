package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2019/8/20 20:20
 * @描述:
 */
@Data
public class SysUser
{
    static final long serialVersionUID = 1L;
    private Integer id;

    private String name;

    private String password;

}
