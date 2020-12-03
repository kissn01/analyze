package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2019/10/22 14:59
 * @描述:
 */
@Data
public class OnlineInfo
{
    private Integer   timeStamp;
    private String   openPlatTypeName;
    private Integer  openPlatType;
    private Integer  osType;
    private Integer  num;
}
