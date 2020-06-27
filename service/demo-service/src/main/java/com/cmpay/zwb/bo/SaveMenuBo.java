package com.cmpay.zwb.bo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author zhouwb
 */
@Data
public class SaveMenuBo {
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
     * @Fields createUser 创建人
     */
    private Long createUser;
    /**
     * @Fields createTime 创建时间
     */
    private LocalDate createTime;
    /**
     * @Fields updateUser 修改人
     */
    private Long updateUser;
    /**
     * @Fields updateTime 修改时间
     */
    private LocalDate updateTime;
}
