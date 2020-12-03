package com.yoooum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @创建人: ${kiss}
 * @时间: 2019/12/27 15:17
 * @描述:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class UserChargeAll
{
    private String dateStamp;
    private int  sumMoney10Num;
    private int  sumMoney10;
    private int  sumMoney20Num;
    private int  sumMoney20;
    private int  sumMoney30Num;
    private int  sumMoney30;
    private int  sumMoney50Num;
    private int  sumMoney50;
    private int  sumMoney100Num;
    private int  sumMoney100;
    private int  sumMoney200Num;
    private int  sumMoney200;
    private int  sumMoney300Num;
    private int  sumMoney300;
    private int  sumMoney500Num;
    private int  sumMoney500;
    private int  sumTop500Num;
    private int  sumTop500;

}
