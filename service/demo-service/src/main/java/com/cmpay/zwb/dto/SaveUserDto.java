package com.cmpay.zwb.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author zhouwb
 */
@Data
public class SaveUserDto {
    private String name;
    private String passwd;
    private String phnumber;
    private String email;
}
