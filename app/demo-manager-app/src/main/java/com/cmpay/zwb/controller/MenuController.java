package com.cmpay.zwb.controller;

import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.zwb.dto.InitMenuDto;
import com.cmpay.zwb.dto.MenuDto;
import com.cmpay.zwb.entity.MenuDO;
import com.cmpay.zwb.enums.MsgEnum;
import com.cmpay.zwb.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @GetMapping("/getById/{id}")
    public MenuDto getByid(@PathVariable("id") Long id){

        return null;
    }
}
