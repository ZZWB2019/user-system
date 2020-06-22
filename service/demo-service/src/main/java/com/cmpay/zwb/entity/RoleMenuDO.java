/*
 * @ClassName RoleMenuDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-21 10:50:50
 */
package com.cmpay.zwb.entity;

import com.cmpay.lemon.framework.annotation.DataObject;
import com.cmpay.zwb.dao.BaseDO;

import java.time.LocalDate;

@DataObject
public class RoleMenuDO extends BaseDO {
    /**
     * @Fields id 
     */
    private Long id;
    /**
     * @Fields rid 
     */
    private Long rid;
    /**
     * @Fields mid 
     */
    private Long mid;
    /**
     * @Fields useSelect 
     */
    private Short useSelect;
    /**
     * @Fields useDelete 
     */
    private Short useDelete;
    /**
     * @Fields useInsert 
     */
    private Short useInsert;
    /**
     * @Fields useUpdate 
     */
    private Short useUpdate;
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

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Short getUseSelect() {
        return useSelect;
    }

    public void setUseSelect(Short useSelect) {
        this.useSelect = useSelect;
    }

    public Short getUseDelete() {
        return useDelete;
    }

    public void setUseDelete(Short useDelete) {
        this.useDelete = useDelete;
    }

    public Short getUseInsert() {
        return useInsert;
    }

    public void setUseInsert(Short useInsert) {
        this.useInsert = useInsert;
    }

    public Short getUseUpdate() {
        return useUpdate;
    }

    public void setUseUpdate(Short useUpdate) {
        this.useUpdate = useUpdate;
    }

    public LocalDate getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(LocalDate creatTime) {
        this.creatTime = creatTime;
    }
}