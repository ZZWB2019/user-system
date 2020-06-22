/*
 * @ClassName IUserDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-21 10:50:50
 */
package com.cmpay.zwb.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.zwb.entity.UserDO;
import com.cmpay.zwb.entity.UserDOKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;

@Mapper
public interface IUserDao extends BaseDao<UserDO, BigInteger> {
    public UserDO getById(@Param("uid") Long id);
}