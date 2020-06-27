package com.cmpay.zwb.bo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author zhouwb
 */
@Data
public class UpdateRoleBo {
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
     * @Fields updateUser 修改人
     */
    private Long updateUser;
    /**
     * @Fields updateTime 修改时间
     */
    private LocalDate updateTime;
}
