package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/25 19:54
 * @描述:
 */
@Data
public class UserInfo
{
    private  Integer platformId;
    private  String  createTime;
    private  Integer chargeSum;
    private  Integer onlineLevel;

    private  int manual;
    private  int maxPlann;
    private  int money;
    private  int userLvl;
    private  String onlineTime;
}
