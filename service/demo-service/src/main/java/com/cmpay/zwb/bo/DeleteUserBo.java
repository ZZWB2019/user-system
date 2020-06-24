package com.cmpay.zwb.bo;

import lombok.Data;

@Data
public class DeleteUserBo {
    private Long uid;
    private Byte isDeleted;
}
