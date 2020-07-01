package com.cmpay.zwb.dto;

import com.cmpay.framework.data.request.GenericDTO;
import lombok.Data;

/**
 * @author zhouwb
 */
@Data
public class SaveRoleDto extends GenericDTO {
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
