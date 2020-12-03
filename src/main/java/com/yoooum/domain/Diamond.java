package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/24 3:52
 * @描述: 钻石统计
 */

@Data
public class Diamond
{
    private String myDate;
    private long addSum;
    private long subSum;
    private long  chargeSum;
    private String  subAvg;
    private long  welfareSum;
    private String  welfareSumAvg;
    private String  storageAvg;
    private int  platformId;
}
