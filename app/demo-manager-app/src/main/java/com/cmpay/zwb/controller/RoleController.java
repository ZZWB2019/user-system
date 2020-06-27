package com.cmpay.zwb.controller;

import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.zwb.bo.SaveRoleBo;
import com.cmpay.zwb.bo.SimpRoleBo;
import com.cmpay.zwb.bo.UpdateRoleBo;
import com.cmpay.zwb.dto.*;
import com.cmpay.zwb.entity.RoleDO;
import com.cmpay.zwb.enums.MsgEnum;
import com.cmpay.zwb.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
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

    /**
     * 通过id查询角色信息
     * @param id
     * @return
     */
    @GetMapping("/getByid/{id}")
    public GenericRspDTO<RoleDto> getRole(@PathVariable("id") Long id){
        RoleDto roleDto = roleService.getByid(id);
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,roleDto);
    }

    /**
     * 添加角色信息
     * @param saveRoleDto
     * @return
     */
    @PostMapping("/save")
    public String saveRole(@RequestBody SaveRoleDto saveRoleDto){
        String msg = "no";
        //String idgenValue = IdGenUtils.generateId("ZHOU_ROLE_IDGEN");
        SaveRoleBo saveRoleBo = new SaveRoleBo();
        //saveRoleBo.setRid(Long.parseLong(idgenValue));
        saveRoleBo.setRid(2L);
        saveRoleBo.setName(saveRoleDto.getName());
        saveRoleBo.setNote(saveRoleDto.getNote());
        //创建人和修改人id要去session里面读取
        saveRoleBo.setCreateUser(1L);
        saveRoleBo.setCreateTime(LocalDate.now());
        saveRoleBo.setUpdateUser(1L);
        saveRoleBo.setUpdateTime(LocalDate.now());
        if (roleService.saveRole(saveRoleBo) == 1){msg = "yes";}
        return msg;
    }

    /**
     * 修改用户信息
     * @param updateRoleDto
     * @return
     */
    @PostMapping("/update")
    public String updateRole(@RequestBody UpdateRoleDto updateRoleDto){
        String msg = "no";
        UpdateRoleBo updateRoleBo = new UpdateRoleBo();
        updateRoleBo.setRid(updateRoleDto.getRid());
        updateRoleBo.setName(updateRoleDto.getName());
        updateRoleBo.setNote(updateRoleDto.getNote());
        //通过session读取当前用户为修改人
        updateRoleBo.setUpdateUser(1L);
        updateRoleBo.setUpdateTime(LocalDate.now());
        if (roleService.updateRole(updateRoleBo) == 1){msg = "yes";}
        return msg;
    }
}
