package com.yoooum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;


/**
 * @创建人: ${kiss}
 * @时间: 2019/12/12 10:57
 * @描述: 玩家钻石消耗
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class SubDiamond
{
    private String   checkDate;
    private Integer  subSum;
    private Integer  subNatural;
    private Integer  subShop;
    private Integer  subGold;
    private Integer  subRevice;
    private Integer  subChallenge;
    private Integer  subMedal;
    private Integer  subOpenBox;
}
