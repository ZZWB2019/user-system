/*
 * @ClassName MenuDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-21 10:50:50
 */
package com.cmpay.zwb.entity;

import com.cmpay.lemon.framework.annotation.DataObject;
import com.cmpay.zwb.dao.BaseDO;

import java.time.LocalDate;

@DataObject
public class MenuDO extends BaseDO {
    /**
     * @Fields mid 
     */
    private Long mid;
    /**
     * @Fields name 
     */
    private String name;
    /**
     * @Fields supid 
     */
    private Long supid;
    /**
     * @Fields menuType 
     */
    private Short menuType;
    /**
     * @Fields creatTime 
     */
    private LocalDate creatTime;

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSupid() {
        return supid;
    }

    public void setSupid(Long supid) {
        this.supid = supid;
    }

    public Short getMenuType() {
        return menuType;
    }

    public void setMenuType(Short menuType) {
        this.menuType = menuType;
    }

    public LocalDate getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(LocalDate creatTime) {
        this.creatTime = creatTime;
    }
}