/*
 * @ClassName IUserRoleDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-22 10:29:31
 */
package com.cmpay.zwb.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.zwb.entity.UserRoleDO;
import com.cmpay.zwb.entity.UserRoleDOKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserRoleDao extends BaseDao<UserRoleDO, UserRoleDOKey> {
}