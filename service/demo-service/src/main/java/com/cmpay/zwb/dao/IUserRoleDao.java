/*
 * @ClassName IUserRoleDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-23 10:50:13
 */
package com.cmpay.zwb.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.zwb.entity.UserRoleDO;
import com.cmpay.zwb.entity.UserRoleDOKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserRoleDao extends BaseDao<UserRoleDO, Long> {

    /**
     * 通过uid查询关联信息
     * @param uid
     * @return
     */
    public UserRoleDO getByUid(Long uid);

    /**
     * 修改用户与角色关联
     * @param userRoleDO
     * @return
     */
    public int updataUserRol(UserRoleDO userRoleDO);
}