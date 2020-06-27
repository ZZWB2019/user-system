package com.cmpay.zwb.service;

import com.cmpay.zwb.dto.MenuDto;
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
}
