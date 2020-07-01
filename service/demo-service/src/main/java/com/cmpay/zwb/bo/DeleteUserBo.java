package com.cmpay.zwb.bo;

import com.cmpay.framework.data.request.GenericDTO;
import lombok.Data;

@Data
public class DeleteUserBo extends GenericDTO {
    private Long uid;
    private Byte isDeleted;
}
