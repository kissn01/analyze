package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2020/1/17 10:54
 * @描述:
 */
@Data
public class Fight
{
    private Integer uin;
    private Integer heroId;
    private Integer arriveStage;
    private String mapId;
    private Integer beginFight;
    private Integer endFight;
    private Integer revive;
}
