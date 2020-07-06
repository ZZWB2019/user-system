/*
 * @ClassName RoleMenuDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-23 10:50:13
 */
package com.cmpay.zwb.entity;

import com.cmpay.framework.data.BaseDO;
import com.cmpay.lemon.framework.annotation.DataObject;
import java.time.LocalDate;

@DataObject
public class RoleMenuDO extends BaseDO {
    /**
     * @Fields id 权限表id
     */
    private Long id;
    /**
     * @Fields rid 角色id
     */
    private Long rid;
    /**
     * @Fields mids 角色菜单关联
     */
    private String mids;

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

    public String getMids() {
        return mids;
    }

    public void setMids(String mid) {
        this.mids = mid;
    }
}