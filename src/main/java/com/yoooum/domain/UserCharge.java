package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2019/12/27 15:17
 * @描述:
 */
@Data
public class UserCharge
{
    private String dateStamp;
    private int  sumMoney10;
    private int  sumMoney20;
    private int  sumMoney30;
    private int  sumMoney50;
    private int  sumMoney100;
    private int  sumMoney200;
    private int  sumMoney300;
    private int  sumMoney500;
    private int  sumTop500;

}
