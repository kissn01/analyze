package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2020/2/14 11:16
 * @描述:
 */
@Data
public class EventCharge
{
    private String ts;
    private int platformId;
    private int itemId;
    private String itemName;
    private int money;
    private int diamond;
    private int afterDiamond;
    private int historyDiamond;
}
