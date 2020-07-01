package com.cmpay.zwb.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author zhouwb
 */
@Data
public class UserDto {
    private Long uid;
    private String name;
    private String passwd;
    private String phnumber;
    private String email;
    private Byte isDeleted;
    private Byte is_Del;
    private Long createUser;
    private LocalDate createTime;
    private Long updateUser;
    private LocalDate updateTime;
    private String userName;
}
