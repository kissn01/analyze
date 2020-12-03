package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2020/1/16 15:11
 * @描述:
 */
@Data
public class AnalysisPay
{
    private  String timeSign;
    private  int  regNum;
    private  int  regPaySum;
    private  int  payTotal;
    private  int  dau;
    private  int  payNum;
    private  String  payRate;
    private  int  newPayNum;
    private  String  newPayRate;
    private  String  payNumArpu;
    private  String  newNumArpu;
    private  String  dauNumArpu;
    private  String  newDauNumArpu;
    private  Integer platformId;

}
