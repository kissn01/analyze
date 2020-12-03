package com.yoooum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @创建人: ${kiss}
 * @时间: 2019/12/13 10:05
 * @描述:  关卡统计新增-玩家各类关卡的参与情况
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class PlannClassify
{
    private String   checkDate;
    private Integer  dau;
    private Integer  mainSum;
    private Integer  goldSum;
    private Integer  materialsSum;
    private Integer  leaderSum;

}
