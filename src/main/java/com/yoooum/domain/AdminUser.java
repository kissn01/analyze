package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2019/5/31 14:12
 * @描述:
 */

/**
 * @Data 会自动生成  getter、setter、NoArgsConstructor注解，即当使用当前注解时，会自动生成包含的所有方法；
 */
@Data
public class AdminUser
{
    private Integer  id;
    private String adminName;
    private String adminPwd;


}
