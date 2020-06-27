package com.cmpay.zwb.dto;

import lombok.Data;

/**
 * @author zhouwb
 */
@Data
public class SaveRoleDto {
    /**
     * @Fields rid 角色id
     */
    private Long rid;
    /**
     * @Fields name 角色名称
     */
    private String name;
    /**
     * @Fields note 角色备注
     */
    private String note;
}
