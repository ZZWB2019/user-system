package com.cmpay.zwb.dto;

import lombok.Data;

@Data
public class DeleteUserDto {
    private Long uid;
    private byte isDelete;
}
