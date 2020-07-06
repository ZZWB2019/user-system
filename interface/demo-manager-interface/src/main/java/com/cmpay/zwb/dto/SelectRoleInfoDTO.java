package com.cmpay.zwb.dto;

import lombok.Data;

import java.util.List;

/**
 * @author zhouwb
 */
@Data
public class SelectRoleInfoDTO {
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
    /**
     * 角色选择的菜单项
     */
    private List<Long> menuIds;
}
