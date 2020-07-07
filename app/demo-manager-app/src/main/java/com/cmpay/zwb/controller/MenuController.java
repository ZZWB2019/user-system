package com.cmpay.zwb.controller;

import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.framework.data.NoBody;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.zwb.bo.DeleteMenuBo;
import com.cmpay.zwb.bo.SaveMenuBo;
import com.cmpay.zwb.bo.UpdateMenuBo;
import com.cmpay.zwb.dto.MenuDto;
import com.cmpay.zwb.dto.SaveMenuDto;
import com.cmpay.zwb.dto.UpdateMenuDto;
import com.cmpay.zwb.entity.MenuDO;
import com.cmpay.zwb.enums.MsgEnum;
import com.cmpay.zwb.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author zhouwb
 */
@RestController
@RequestMapping("v1/ui-template/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 通过id查询菜单信息
     * @param id
     * @return
     */
    @GetMapping("/info/{id}")
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
    public GenericRspDTO<NoBody> saveMenu(@Validated @RequestBody SaveMenuDto saveMenuDto){
        String idgenValue = IdGenUtils.generateId("ZHOU_MENU_IDGEN");
        SaveMenuBo saveMenuBo = new SaveMenuBo();
        saveMenuBo.setMid(Long.parseLong(idgenValue));
        saveMenuBo.setName(saveMenuDto.getName());
        saveMenuBo.setSupid(saveMenuDto.getParentId());
        saveMenuBo.setMenuType(saveMenuDto.getMenuType());
        saveMenuBo.setPath(saveMenuDto.getPath());
        //通过session读取当前用户信息
        saveMenuBo.setCreateUser(1L);
        saveMenuBo.setCreateTime(LocalDate.now());
        saveMenuBo.setUpdateUser(1L);
        saveMenuBo.setUpdateTime(LocalDate.now());
        if (menuService.saveMenu(saveMenuBo) == 1){return GenericRspDTO.newInstance(MsgEnum.SUCCESS);}
        return GenericRspDTO.newInstance(MsgEnum.FAIL);
    }

    /**
     * 修改菜单信息
     * @param updateMenuDto
     * @return
     */
    @PostMapping("/update")
    public GenericRspDTO<NoBody> updateMenu(@Validated @RequestBody UpdateMenuDto updateMenuDto){
        UpdateMenuBo updateMenuBo = new UpdateMenuBo();
        updateMenuBo.setMid(updateMenuDto.getId());
        updateMenuBo.setName(updateMenuDto.getName());
        updateMenuBo.setSupid(updateMenuDto.getParentId());
        updateMenuBo.setMenuType(updateMenuDto.getMenuType());
        updateMenuBo.setPath(updateMenuDto.getPath());
        //从session中读取当前用户的信息
        updateMenuBo.setUpdateUser(1L);
        updateMenuBo.setUpdateTime(LocalDate.now());
        if (menuService.updateMenu(updateMenuBo) == 1){return GenericRspDTO.newInstance(MsgEnum.SUCCESS);}
        return GenericRspDTO.newInstance(MsgEnum.FAIL);
    }

    /**
     * 查询所有的menu对象信息
     * @return
     */
    @GetMapping("/list")
    public GenericRspDTO<List<Map>> queryListMenu(){
        List<Map> list = menuService.findAllMenu();
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,list);
    }

    /**
     * 自己的查询对象方法
     * @return
     */
    @GetMapping("/select")
    public GenericRspDTO<List<MenuDto>> quereyMyListMenu(){
        List<MenuDO> list = menuService.myFindAllMenu();
        List<MenuDto> menuDtos = menuService.listFormate(list);
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,menuDtos);
    }

    /**
     * 删除方法
     * @return
     */
    @DeleteMapping("delete/{id}")
    public GenericRspDTO<NoBody> moveMenu(@PathVariable("id") Long id){
        DeleteMenuBo deleteMenuBo = new DeleteMenuBo();
        deleteMenuBo.setMid(id);
        if (menuService.deleteMenu(deleteMenuBo) == 1){return GenericRspDTO.newInstance(MsgEnum.SUCCESS);}
        return GenericRspDTO.newInstance(MsgEnum.FAIL);
    }
}
