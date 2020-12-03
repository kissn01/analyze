package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2019/11/29 15:48
 * @描述:
 */
@Data
public class NaturalLottery
{
    private String  date;
    private Integer dau;
    private Integer goldNum;
    private String   goldRatio;
    private String   avgGold;
    private Integer diamondNum;
    private String   diamondRatio;
    private String   avgDiamond;
    private Integer naturalNum;
    private String   naturalRatio;
    private String   avgNatural;
    private Integer freeNum;
    private String   freeRatio;
}
