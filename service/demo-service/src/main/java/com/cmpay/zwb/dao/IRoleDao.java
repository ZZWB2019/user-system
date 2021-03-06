/*
 * @ClassName IRoleDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-23 10:50:13
 */
package com.cmpay.zwb.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.zwb.entity.RoleDO;
import com.cmpay.zwb.entity.RoleDOKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IRoleDao extends BaseDao<RoleDO, Long> {

    /**
     * 通过id查询角色信息
     * @param id
     * @return
     */
    RoleDO getById(@Param("rid") Long id);

    /**
     * 修改角色信息
     * @param roleDO
     * @return
     */
    int updateRole(RoleDO roleDO);

    /**
     * 批量删除角色信息
     * @param list
     * @return
     */
    int deleteRole(List<Long> list);
}