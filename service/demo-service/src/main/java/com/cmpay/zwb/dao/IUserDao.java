/*
 * @ClassName IUserDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-23 10:50:13
 */
package com.cmpay.zwb.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.zwb.entity.UserDO;
import com.cmpay.zwb.entity.UserDOKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IUserDao extends BaseDao<UserDO, Long> {

    /**
     * 通过id查询UserDo
     * @param id
     * @return
     */
    UserDO getById(@Param("uid") Long id);

    /**
     * 通过账号密码进行查询
     * @param name
     * @param passwd
     * @return
     */
    UserDO getByLogin(@Param("name") String name, @Param("passwd") String passwd);

    /**
     * 修改用户信息
     * @return
     */
    int updateUserInfo(UserDO userDO);

    /**
     * 批量删除角色对象
     * @param list
     * @return
     */
    public int ListDelUserr(List<Long> list);
}