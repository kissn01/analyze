package com.yoooum.domain;

import lombok.Data;

/**
 * @ClassName DialViewAD
 * @Description TODO
 * @Author kiss
 * @Date 2020/5/11 11:32
 * @Version 1.0
 */
@Data
public class DialViewAD
{
    private String dateSign;
    private Integer properSum;
    private Integer proper01;
    private String  properAvg01;
    private Integer proper02;
    private String properAvg02;
    private Integer proper03;
    private String properAvg03;
    private Integer proper04;
    private String properAvg04;
    private Integer proper05;
    private String properAvg05;
    private Integer properTop05;
    private String properTopAvg05;
    public DialViewAD(String dateSign, Integer properSum, Integer proper01, String properAvg01, Integer proper02, String properAvg02, Integer proper03, String properAvg03, Integer proper04, String properAvg04, Integer proper05, String properAvg05, Integer properTop05, String properTopAvg05)
    {
        this.dateSign = dateSign;
        this.properSum = properSum;
        this.proper01 = proper01;
        this.properAvg01 = properAvg01;
        this.proper02 = proper02;
        this.properAvg02 = properAvg02;
        this.proper03 = proper03;
        this.properAvg03 = properAvg03;
        this.proper04 = proper04;
        this.properAvg04 = properAvg04;
        this.proper05 = proper05;
        this.properAvg05 = properAvg05;
        this.properTop05 = properTop05;
        this.properTopAvg05 = properTopAvg05;
    }

    public DialViewAD()
    {
    }
}
