package com.cmpay.zwb.bo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author zhouwb
 */
@Data
public class UpdateMenuBo {
    /**
     * @Fields mid 菜单id
     */
    private Long mid;
    /**
     * @Fields name 菜单名称
     */
    private String name;
    /**
     * @Fields supid 上级菜单
     */
    private Long supid;
    /**
     * @Fields menuType 菜单类型
     */
    private Short menuType;
    /**
     * @Fields updateUser 修改人
     */
    private Long updateUser;
    /**
     * @Fields updateTime 修改时间
     */
    private LocalDate updateTime;
}
