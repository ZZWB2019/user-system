package com.cmpay.zwb.dto;

import lombok.Data;

/**
 * @author zhouwb
 */
@Data
public class SaveMenuDto {
    /**
     * @Fields name 菜单名称
     */
    private String name;
    /**
     * @Fields supid 上级菜单
     */
    private Long parentId;
    /**
     * @Fields menuType 菜单类型  0 -- 目录   1 -- 菜单
     */
    private Short menuType;
    /**
     * @Fields path 菜单类型
     */
    private String path;
}
