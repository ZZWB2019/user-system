/*
 * @ClassName UserDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-22 10:29:31
 */
package com.cmpay.zwb.entity;

import com.cmpay.lemon.framework.annotation.DataObject;
import com.cmpay.zwb.dao.BaseDO;

import java.time.LocalDate;

@DataObject
public class UserDO extends BaseDO {
    /**
     * @Fields uid 用户id
     */
    private Long uid;
    /**
     * @Fields name 用户名
     */
    private String name;
    /**
     * @Fields passwd 用户密码
     */
    private String passwd;
    /**
     * @Fields phnumber 联系电话
     */
    private String phnumber;
    /**
     * @Fields email 邮箱
     */
    private String email;
    /**
     * @Fields isDeleted 禁用： 0 -- 正常；1 -- 禁用
     */
    private Byte isDeleted;
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
    private String updateUser;
    /**
     * @Fields updateTime 修改时间
     */
    private LocalDate updateTime;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPhnumber() {
        return phnumber;
    }

    public void setPhnumber(String phnumber) {
        this.phnumber = phnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public LocalDate getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", phnumber='" + phnumber + '\'' +
                ", email='" + email + '\'' +
                ", isDeleted=" + isDeleted +
                ", createUser=" + createUser +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}