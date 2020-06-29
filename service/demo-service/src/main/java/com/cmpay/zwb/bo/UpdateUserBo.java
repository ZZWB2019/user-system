package com.cmpay.zwb.bo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author zhouwb
 */
@Data
public class UpdateUserBo {
    /**
     * @Fields uid 用户id
     */
    private Long uid;
    /**
     * @Fields name 账号
     */
    private String userName;
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
    /**
     * @Fields userName 用户姓名
     */
    private String name;
    /**
     * @Fields email 邮箱
     */
    private String email;
    /**
     * @Fields updateUser 修改人
     */
    private Long updateUser;
    /**
     * @Fields updateTime 修改时间
     */
    private LocalDate updateTime;
}
