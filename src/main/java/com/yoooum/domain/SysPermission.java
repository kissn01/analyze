package com.yoooum.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/8/21 14:21
 * @描述:
 */
@Data
public class SysPermission implements Serializable
{

    static final long serialVersionUID = 1L;

    private Integer id;

    private String url;

    private Integer roleId;

    private String permission;

    private List permissions;
    public List getPermissions() {
        return Arrays.asList(this.permission.trim().split(","));
    }

    public void setPermissions(List permissions) {
        this.permissions = permissions;
    }
}
