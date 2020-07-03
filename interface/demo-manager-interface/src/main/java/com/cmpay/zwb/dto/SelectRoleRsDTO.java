package com.cmpay.zwb.dto;

import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.framework.data.response.PageableRspDTO;
import lombok.Data;

import java.util.List;

/**
 * @author zhouwb
 */
@Data
public class SelectRoleRsDTO extends PageableRspDTO {

    private List<RoleDto> list;
}
