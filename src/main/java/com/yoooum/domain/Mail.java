package com.yoooum.domain;

import lombok.Data;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/18 9:01
 * @描述:
 */
@Data
public class Mail
{
    private Integer environmentId;
    private String userList;
    private Integer emailId;
    private String emailTitle;
    private String mailDesc;
    private String itemList;

}
