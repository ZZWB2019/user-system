package com.cmpay.zwb.dto;

import com.cmpay.framework.data.response.PageableRspDTO;
import lombok.Data;

/**
 * @author zhouwb
 */
@Data
public class SimpRoleDto extends PageableRspDTO {
    /**
     * @Fields rid 角色id
     */
    private Long rid;
    /**
     * @Fields name 角色名称
     */
    private String name;}
