package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/22 13:55
 * @描述:
 */
@Data
public class Shopping
{
    private String myDate;
    private Integer goodId;
    private String goodName;
    private int  buyCount;
    private int  buyUser;
    private int  sumMoney;
}
