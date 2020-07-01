package com.cmpay.zwb.dto;

import java.util.List;
import java.util.Map;

/**
 * @author zhouwb
 */
public class MenuExDto {
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
     * @Fields childrenMap 子类信息map集合
     */
    private Map<String,Object> childrenMap;
}
