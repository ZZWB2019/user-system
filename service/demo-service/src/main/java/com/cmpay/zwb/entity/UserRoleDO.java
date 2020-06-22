/*
 * @ClassName UserRoleDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-22 10:29:31
 */
package com.cmpay.zwb.entity;

import com.cmpay.lemon.framework.annotation.DataObject;
import com.cmpay.zwb.dao.BaseDO;

import java.time.LocalDate;

@DataObject
public class UserRoleDO extends BaseDO {
    /**
     * @Fields id 
     */
    private Long id;
    /**
     * @Fields uid 
     */
    private Long uid;
    /**
     * @Fields rid 
     */
    private Long rid;
    /**
     * @Fields creatTime 
     */
    private LocalDate creatTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public LocalDate getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(LocalDate creatTime) {
        this.creatTime = creatTime;
    }
}