package com.cmpay.zwb.service.impl;

import com.cmpay.zwb.bo.SaveMenuBo;
import com.cmpay.zwb.dao.IMenuDao;
import com.cmpay.zwb.dto.MenuDto;
import com.cmpay.zwb.dto.SelectMenuDto;
import com.cmpay.zwb.entity.MenuDO;
import com.cmpay.zwb.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhouwb
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private IMenuDao menuDao;

    /**
     * 条件查询菜单信息
     * @param selectMenuDto
     * @return
     */
    @Override
    public List<MenuDO> selectMenu(SelectMenuDto selectMenuDto) {
        if (selectMenuDto == null){return menuDao.find(null);}
        MenuDO menuDO = new MenuDO();
        menuDO.setName(selectMenuDto.getName());
        return menuDao.find(menuDO);
    }

    /**
     * 转换list格式
     * @param menuDOS
     * @return
     */
    @Override
    public List<MenuDto> listFormate(List<MenuDO> menuDOS) {
        Iterator<MenuDO> it = menuDOS.iterator();
        List<MenuDto> list = new ArrayList<MenuDto>();

        while (it.hasNext()) {
            MenuDto menuDto = new MenuDto();
            MenuDO temp = it.next();
            BeanUtils.copyProperties(temp,menuDto);
            list.add(menuDto);
        }
        return list;
    }

    /**
     * 通过id查询菜单信息
     * @param id
     * @return
     */
    @Override
    public MenuDO getById(Long id) {return menuDao.getById(id);
    }

    /**
     * 插入菜单信息
     * @param saveMenuBo
     * @return
     */
    @Override
    public int saveMenu(SaveMenuBo saveMenuBo) {
        MenuDO menuDO = new MenuDO();
        BeanUtils.copyProperties(saveMenuBo,menuDO);
        return menuDao.insert(menuDO);
    }
}
