package com.cmpay.zwb.dto;

import com.cmpay.framework.data.request.GenericDTO;
import lombok.Data;

import java.util.List;

/**
 * @author zhouwb
 */
@Data
public class DeleteRoleDto extends GenericDTO {

    //删除的角色id
    private List<Long> delList;
}
