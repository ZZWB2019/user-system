/*
 * @ClassName IMenuDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-21 10:50:50
 */
package com.cmpay.zwb.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.zwb.entity.MenuDO;
import com.cmpay.zwb.entity.MenuDOKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMenuDao extends BaseDao<MenuDO, Long> {
}