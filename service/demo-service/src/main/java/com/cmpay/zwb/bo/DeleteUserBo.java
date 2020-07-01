package com.cmpay.zwb.bo;

import com.cmpay.framework.data.request.GenericDTO;
import lombok.Data;

import java.util.List;

@Data
public class DeleteUserBo extends GenericDTO {
    private List<Long> delList;
    private Byte isDeleted;
}
