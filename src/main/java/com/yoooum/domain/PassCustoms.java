package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/27 17:00
 * @描述:
 */
@Data
public class PassCustoms
{
    private  int levelId;
    private  int passNum;
    private  int passCount;
    private  int openNum;
    private  double passRate;
}
