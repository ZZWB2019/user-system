/*
 * @ClassName IMenuDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-23 10:50:13
 */
package com.cmpay.zwb.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.zwb.entity.MenuDO;
import com.cmpay.zwb.entity.MenuDOKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IMenuDao extends BaseDao<MenuDO, Long> {

    /**
     * 通过id查询菜单信息
     * @param id
     * @return
     */
    MenuDO getById(@Param("mid") Long id);

    /**
     * 修改菜单信息
     * @param menuDO
     * @return
     */
    int updateMenu(MenuDO menuDO);

    /**
     * 通过id逻辑删除
     * @param id
     * @return
     */
    int deleteMenu(@Param("mid") Long id);
}