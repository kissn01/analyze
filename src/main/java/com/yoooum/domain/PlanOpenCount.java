package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2019/10/21 10:25
 * @描述:
 */
@Data
public class PlanOpenCount
{
    private String   myDate;
    private float  openAvg;
    private Integer  openOne;
    private Integer  openTwo;
    private Integer  openThree;
    private Integer  openFour;
    private Integer  openFive;
    private Integer  openST;
    private Integer  openGtT;

}
