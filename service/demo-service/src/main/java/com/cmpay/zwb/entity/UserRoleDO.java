/*
 * @ClassName UserRoleDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-23 10:50:13
 */
package com.cmpay.zwb.entity;

import com.cmpay.framework.data.BaseDO;
import com.cmpay.lemon.framework.annotation.DataObject;
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
     * @Fields rids
     */
    private String rids;

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

    public String getRids() {
        return rids;
    }

    public void setRids(String rid) {
        this.rids = rid;
    }
}