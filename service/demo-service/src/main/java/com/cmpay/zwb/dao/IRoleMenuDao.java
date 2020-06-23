/*
 * @ClassName IRoleMenuDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-23 10:50:13
 */
package com.cmpay.zwb.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.zwb.entity.RoleMenuDO;
import com.cmpay.zwb.entity.RoleMenuDOKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IRoleMenuDao extends BaseDao<RoleMenuDO, RoleMenuDOKey> {
}