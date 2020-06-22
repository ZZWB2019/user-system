/*
 * @ClassName IRoleDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-21 10:50:50
 */
package com.cmpay.zwb.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.zwb.entity.RoleDO;
import com.cmpay.zwb.entity.RoleDOKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IRoleDao extends BaseDao<RoleDO, Long> {
}