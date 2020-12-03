package com.yoooum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @创建人: ${kiss}
 * @时间: 2019/12/4 13:50
 * @描述:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class ViewADplay
{
    private String date;
    private int dau;
    private int  playCount;
    private int  playSum;
    private String countDauAvg;
    private String playCountAvg;
    private String  playNumAvg;
    private int  reviveCount;
    private int  reviveSum;
    private String  reviveNumAvg;
    private int  dialCount;
    private int  dialSum;
    private String  dialCountAvg;
    private String  dialNumAvg;
    private int  recoverCount;
    private int  recoverSum;
    private String  recoverCountAvg;
    private String  recoverNumAvg;
    private int  shopCount;
    private int  shopSum;
    private String  shopCountAvg;
    private String  shopNumAvg;
    private int  signCount;
    private int  signSum;
    private String  signNumAvg;
    private int  coinCount;
    private int  coinSum;
    private String  coinNumAvg;
    private int  skillCount;
    private int  skillSum;
    private String  skillNumAvg;
    private int  attackCount;
    private int  attackSum;
    private String  attackNumAvg;
    private int  boxAgainCount;
    private int  boxAgainSum;
    private String  boxAgainNumAvg;
}
