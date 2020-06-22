package com.cmpay.zwb.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InitUserDto {
    /**
     * @Fields uid
     */
    private Long uid;
    /**
     * @Fields name
     */
    private String name;
    /**
     * @Fields passwd
     */
    private String passwd;
    /**
     * @Fields createTime
     */
    private LocalDate createTime;
    /**
     * @Fields phnumber
     */
    private String phnumber;
    /**
     * @Fields isDeleted
     */
    private Byte isDeleted;
    /**
     * @Fields email
     */
    private String email;
}
