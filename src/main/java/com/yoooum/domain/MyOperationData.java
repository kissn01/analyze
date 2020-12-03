package com.yoooum.domain;

import lombok.Data;


/**
 * @创建人: ${kiss}
 * @时间: 2019/9/20 17:57
 * @描述:
 */
@Data
public class MyOperationData
{
    private Integer id;
    private String myDate;
    private Integer  newAddUser;
    private Integer  activeUser;
    private Integer  chargeUser;
    private String newUserChargeAmount;
    private Integer chargeAmount;
    private String arppu;
    private String arpu;
    private String pur;
    private String morrowRetention;
    private String threeDayRetention;
    private String sevenDayRetention;
    private String fifteenDayRetention;
    private String newUserPayCount;
    private String newUserPayRate;
    private String newUserArpu;
    private String newDauUserArpu;
    private Integer platformId;
}
