package com.cmpay.zwb.controller;

import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.zwb.bo.SimpRoleBo;
import com.cmpay.zwb.dto.InitRsRoleDto;
import com.cmpay.zwb.dto.RoleDto;
import com.cmpay.zwb.dto.SimpRoleDto;
import com.cmpay.zwb.entity.RoleDO;
import com.cmpay.zwb.enums.MsgEnum;
import com.cmpay.zwb.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouwb
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * 查询角色信息
     * @param simpRoleDto
     * @return
     */
    public List<RoleDO> findRole(SimpRoleDto simpRoleDto){
        SimpRoleBo simpRoleBo = new SimpRoleBo();
        BeanUtils.copyProperties(simpRoleDto,simpRoleBo);
        return roleService.findRole(simpRoleBo);
    }

    /**
     * 初始化角色查询
     * @return
     */
    @GetMapping("/info")
    public GenericRspDTO<InitRsRoleDto> init(){
        List<RoleDO> roleDOS = PageUtils.pageQuery(1,4,() -> { return this.roleService.findRole(null);});
        List<RoleDto> list = roleService.listFromate(roleDOS);
        InitRsRoleDto initRsRoleDto = new InitRsRoleDto(list);
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,initRsRoleDto);
    }
}
