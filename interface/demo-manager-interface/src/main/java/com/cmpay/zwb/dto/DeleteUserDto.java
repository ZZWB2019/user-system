package com.cmpay.zwb.dto;

import com.cmpay.framework.data.request.GenericDTO;
import lombok.Data;

import java.util.List;

@Data
public class DeleteUserDto extends GenericDTO {
    private List<Long> id;
    private byte isDelete;
}
