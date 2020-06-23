/*
 * @ClassName RoleDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-23 10:50:13
 */
package com.cmpay.zwb.entity;

import com.cmpay.framework.data.BaseDO;
import com.cmpay.lemon.framework.annotation.DataObject;
import java.time.LocalDate;

@DataObject
public class RoleDO extends BaseDO {
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

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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