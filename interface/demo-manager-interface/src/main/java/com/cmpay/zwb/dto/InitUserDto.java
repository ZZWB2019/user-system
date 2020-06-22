package com.cmpay.zwb.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InitUserDto {
    private Long uid;
    private String name;
    private String passwd;
    private LocalDate createTime;
    private String phnumber;
    private Byte isDeleted;
    private String email;
}
