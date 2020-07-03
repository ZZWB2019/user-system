/*
 * @ClassName MenuDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-23 10:50:13
 */
package com.cmpay.zwb.entity;

import com.cmpay.framework.data.BaseDO;
import com.cmpay.lemon.framework.annotation.DataObject;
import java.time.LocalDate;

@DataObject
public class MenuDO extends BaseDO {
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
     * @Fields menuType 菜单类型  0 -- 目录   1 -- 菜单
     */
    private Short menuType;
    /**
     * @Fields path 菜单类型
     */
    private String path;
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
    /**
     * @Fields isDel 逻辑删除判断 0 -- 正常；1 -- 删除
     */
    private Short isDel;

    public Short getIsDel() {return isDel;}

    public void setIsDel(Short isDel) {this.isDel = isDel;}

    public String getPath() {return path;}

    public void setPath(String path) {this.path = path;}

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

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public LocalDate getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }
}