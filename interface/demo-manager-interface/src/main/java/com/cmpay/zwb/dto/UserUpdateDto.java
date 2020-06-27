package com.cmpay.zwb.dto;

import lombok.Data;


/**
 * @author zhouwb
 */
@Data
public class UserUpdateDto {
    /**
     * @Fields uid 用户id
     */
    private Long uid;
    /**
     * @Fields name 账号
     */
    private String name;
    /**
     * @Fields passwd
     */
    private String passwd;
    /**
     * @Fields phnumber 联系电话
     */
    private String phnumber;
    /**
     * @Fields email 邮箱
     */
    private String email;
    /**
     * @Fields userName 用户姓名
     */
    private String userName;
}
