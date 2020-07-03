package com.cmpay.zwb.service;

import com.cmpay.zwb.bo.DeleteMenuBo;
import com.cmpay.zwb.bo.SaveMenuBo;
import com.cmpay.zwb.bo.UpdateMenuBo;
import com.cmpay.zwb.dto.MenuDto;
import com.cmpay.zwb.dto.SaveMenuDto;
import com.cmpay.zwb.dto.SelectMenuDto;
import com.cmpay.zwb.entity.MenuDO;

import java.util.List;
import java.util.Map;

/**
 * @author zhouwb
 */
public interface MenuService {

    /**
     * 查询菜单信息
     * @param selectMenuDto
     * @return
     */
    List<MenuDO> selectMenu(SelectMenuDto selectMenuDto);

    /**
     * 转换list格式
     * @param menuDOS
     * @return
     */
    List<MenuDto> listFormate(List<MenuDO> menuDOS);

    /**
     * 根据id查询菜单信息
     * @param id
     * @return
     */
    MenuDO getById(Long id);

    /**
     * 插入菜单
     * @param saveMenuBo
     * @return
     */
    int saveMenu(SaveMenuBo saveMenuBo);

    /**
     * 修改菜单信息
     * @param updateMenuBo
     * @return
     */
    int updateMenu(UpdateMenuBo updateMenuBo);

    /**
     * 迭代查询所有的菜单信息
     * @return
     */
    public List<Map> findAllMenu();

    /**
     * 排序查询所有的菜单信息
     * @return
     */
    public List<MenuDO> myFindAllMenu();

    /**
     * 逻辑删除菜单信息
     * @param deleteMenuBo
     * @return
     */
    public int deleteMenu(DeleteMenuBo deleteMenuBo);
}
