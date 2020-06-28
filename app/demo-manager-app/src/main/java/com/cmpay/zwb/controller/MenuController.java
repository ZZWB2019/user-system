package com.cmpay.zwb.controller;

import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.zwb.bo.SaveMenuBo;
import com.cmpay.zwb.bo.UpdateMenuBo;
import com.cmpay.zwb.dto.InitMenuDto;
import com.cmpay.zwb.dto.MenuDto;
import com.cmpay.zwb.dto.SaveMenuDto;
import com.cmpay.zwb.dto.UpdateMenuDto;
import com.cmpay.zwb.entity.MenuDO;
import com.cmpay.zwb.enums.MsgEnum;
import com.cmpay.zwb.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @author zhouwb
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 初始化菜单管理界面
     * @return
     */
    @GetMapping("/info")
    public GenericRspDTO<InitMenuDto> init(){
        List<MenuDO> roleDOS = PageUtils.pageQuery(1,4,() -> { return this.menuService.selectMenu(null);});
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,new InitMenuDto(menuService.listFormate(roleDOS)));
    }

    /**
     * 通过id查询菜单信息
     * @param id
     * @return
     */
    @GetMapping("/getById/{id}")
    public GenericRspDTO<MenuDto> getByid(@PathVariable("id") Long id){
        MenuDO menuDO = menuService.getById(id);
        MenuDto menuDto = new MenuDto();
        BeanUtils.copyProperties(menuDO,menuDto);
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,menuDto);
    }

    /**
     * 插入菜单信息
     * @param saveMenuDto
     * @return
     */
    @PostMapping("/save")
    public Object saveMenu(@RequestBody SaveMenuDto saveMenuDto){
        //String idgenValue = IdGenUtils.generateId("ZHOU_MENU_IDGEN");
        String msg = "no";
        SaveMenuBo saveMenuBo = new SaveMenuBo();
        //saveMenuBo.setMid(Long.parseLong(idgenValue));
        saveMenuBo.setMid(2L);
        saveMenuBo.setName(saveMenuDto.getName());
        saveMenuBo.setSupid(saveMenuDto.getSupid());
        saveMenuBo.setMenuType(saveMenuDto.getMenuType());
        //通过session读取当前用户信息
        saveMenuBo.setCreateUser(1L);
        saveMenuBo.setCreateTime(LocalDate.now());
        saveMenuBo.setUpdateUser(1L);
        saveMenuBo.setUpdateTime(LocalDate.now());
        if (menuService.saveMenu(saveMenuBo) == 1){msg = "yes";}
        return msg;
    }

    public Object updateMenu(UpdateMenuDto updateMenuDto){
        UpdateMenuBo updateMenuBo = new UpdateMenuBo();
        updateMenuBo.setMid(updateMenuDto.getMid());
        updateMenuBo.setName(updateMenuDto.getName());
        updateMenuBo.setSupid(updateMenuDto.getSupid());
        updateMenuBo.setMenuType(updateMenuDto.getMenuType());
        //从session中读取当前用户的信息
        updateMenuBo.setUpdateUser(1L);
        updateMenuBo.setUpdateTime(LocalDate.now());
        return null;
    }
}
