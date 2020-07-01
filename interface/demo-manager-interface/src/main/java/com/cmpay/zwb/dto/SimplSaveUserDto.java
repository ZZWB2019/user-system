package com.cmpay.zwb.dto;

import lombok.Data;

import java.util.List;

/**
 * @author zhouwb
 */
@Data
public class SimplSaveUserDto {
    private Long rid;
    private String name;
    private String passwd;
    private String phnumber;
    private String email;
    private byte is_delete;
    List<Long> roleIds;
}
