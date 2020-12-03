package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2019/10/8 17:31
 * @描述:
 */
@Data
public class DirectBuy
{
    private String myDate;
    private int    itemId;
    private Integer itemPrice;
    private String itemName;
    private int buyUser;
    private int buyCount;
    private Integer totalMoney;

}
