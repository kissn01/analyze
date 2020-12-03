package com.yoooum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @创建人: ${kiss}
 * @时间: 2019/10/16 14:15
 * @描述:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class FightHero
{
    private Integer  roleId;
    private Integer  fightNum;
    private String   name;
}
