/*
 * @ClassName UserDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-21 10:50:50
 */
package com.cmpay.zwb.entity;

import com.cmpay.lemon.framework.annotation.DataObject;
import com.cmpay.zwb.dao.BaseDO;
import lombok.Data;

import java.time.LocalDate;

@DataObject
@Data
public class UserDO extends BaseDO {
    /**
     * @Fields uid 
     */
    private Long uid;
    /**
     * @Fields name 
     */
    private String name;
    /**
     * @Fields passwd 
     */
    private String passwd;
    /**
     * @Fields createTime 
     */
    private LocalDate createTime;
    /**
     * @Fields phnumber 
     */
    private String phnumber;
    /**
     * @Fields isDeleted 
     */
    private Byte isDeleted;
    /**
     * @Fields email 
     */
    private String email;


    @Override
    public String toString() {
        return "UserDO{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", createTime=" + createTime +
                ", phnumber='" + phnumber + '\'' +
                ", isDeleted=" + isDeleted +
                ", email='" + email + '\'' +
                '}';
    }
}