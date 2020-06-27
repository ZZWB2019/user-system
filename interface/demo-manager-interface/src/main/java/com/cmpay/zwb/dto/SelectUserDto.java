package com.cmpay.zwb.dto;

import lombok.Data;

/**
 * @author zhouwb
 * 用于查询用户信息的Dto
 * 封装的是用户查询信息
 */
@Data
public class SelectUserDto {
    private String name;
    private String userName;
}
