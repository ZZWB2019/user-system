package com.cmpay.zwb.dto;

import com.cmpay.framework.data.request.GenericDTO;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

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
    @NotBlank
    private String name;
    /**
     * @Fields note 角色备注
     */
    private String note;
    /**
     * 选择的菜单权限
     */
    private List<Long> menuIdList;
}
