/*
 * @ClassName RoleDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-21 10:50:50
 */
package com.cmpay.zwb.entity;

import com.cmpay.lemon.framework.annotation.DataObject;
import com.cmpay.zwb.dao.BaseDO;

import java.time.LocalDate;

@DataObject
public class RoleDO extends BaseDO {
    /**
     * @Fields rid 
     */
    private Long rid;
    /**
     * @Fields name 
     */
    private String name;
    /**
     * @Fields createTime 
     */
    private LocalDate createTime;
    /**
     * @Fields note 
     */
    private String note;

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

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}