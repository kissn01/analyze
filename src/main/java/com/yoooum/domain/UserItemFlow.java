package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2020/1/14 15:10
 * @描述:
 */
@Data
public class UserItemFlow
{
    private  int ts;
    private  String strTs;
    private  int reason;
    private  String strReason;
    private  int itemId;
    private  String strItemName;
    private  int changeCount;
    private  int afterCount;
}
