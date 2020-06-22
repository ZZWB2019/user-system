/*
 * @ClassName IUserDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-22 10:29:31
 */
package com.cmpay.zwb.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.zwb.entity.UserDO;
import com.cmpay.zwb.entity.UserDOKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IUserDao extends BaseDao<UserDO, Long> {
    /**
     * 通过id查询一个User对象
     * @param id
     * @return
     */
    public UserDO getById(@Param("uid") Long id);

    /**
     * 通过用户名和密码登录方式查询用户对象
     * @param name
     * @param passwd
     * @return
     */
    public UserDO getByLogin(@Param("name")String name,@Param("passwd") String passwd);
}