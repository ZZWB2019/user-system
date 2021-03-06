package com.cmpay.zwb.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @author zhouwb
 */
@Data
public class UpdateRoleDto {
    /**
     * @Fields rid 角色id
     */
    private Long rid;
    /**
     * @Fields name 角色名称
     */
    @NotBlank
    private String name;
    /**
     * @Fields note 角色备注
     */
    private String note;
    /**
     * 存入的菜单选择
     */
    private List<Long> menuIdList;
}
