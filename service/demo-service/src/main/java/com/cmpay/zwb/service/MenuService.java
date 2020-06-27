package com.cmpay.zwb.service;

import com.cmpay.zwb.bo.SaveMenuBo;
import com.cmpay.zwb.dto.MenuDto;
import com.cmpay.zwb.dto.SaveMenuDto;
import com.cmpay.zwb.dto.SelectMenuDto;
import com.cmpay.zwb.entity.MenuDO;

import java.util.List;

/**
 * @author zhouwb
 */
public interface MenuService {

    /**
     * 查询菜单信息
     * @param selectMenuDto
     * @return
     */
    public List<MenuDO> selectMenu(SelectMenuDto selectMenuDto);

    /**
     * 转换list格式
     * @param menuDOS
     * @return
     */
    public List<MenuDto> listFormate(List<MenuDO> menuDOS);

    /**
     * 根据id查询菜单信息
     * @param id
     * @return
     */
    public MenuDO getById(Long id);

    /**
     * 插入菜单
     * @param saveMenuBo
     * @return
     */
    public int saveMenu(SaveMenuBo saveMenuBo);
}
