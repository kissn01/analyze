package com.yoooum.domain;

import lombok.Data;


/**
 * @创建人: ${kiss}
 * @时间: 2019/9/22 1:09
 * @描述: 用户留存表
 */
@Data
public class MyUserRetention
{
    private Integer id;
    private String myDate;
    private int newAddUser;
    private int activeUser;
    private String twoDayRet;
    private String threeDayRet;
    private String fourDayRet;
    private String fiveDayRet;
    private String sixDayRet;
    private String sevenDayRet;
    private String eightDayRet;
    private String nineDayRet;
    private String tenDayRet;
    private String elevenDayRet;
    private String twelveDayRet;
    private String thirteenDayRet;
    private String fourteenDayRet;
    private String fifteenDayRet;
    private String thirtyDayRet;
    private String  sixtyDayRet;
    private int platformId;
}
