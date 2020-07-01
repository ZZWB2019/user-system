package com.cmpay.zwb.controller;

import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.framework.data.NoBody;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.zwb.bo.DeleteRoleBo;
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
@RequestMapping("/v1/ui-template/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * 查询角色信息
     * @param simpRoleDto
     * @return
     */
    @GetMapping("/select")
    public GenericRspDTO<List<RoleDO>> findRole(SimpRoleDto simpRoleDto){
        SimpRoleBo simpRoleBo = new SimpRoleBo();
        BeanUtils.copyProperties(simpRoleDto,simpRoleBo);
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,roleService.findRole(simpRoleBo));
    }

    /**
     * 初始化角色查询
     * @return
     */
    @PostMapping("/list")
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
    @GetMapping("/info/{id}")
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
    public GenericRspDTO<NoBody> saveRole(@RequestBody SaveRoleDto saveRoleDto){
        String idgenValue = IdGenUtils.generateId("ZHOU_ROLE_IDGEN");
        SaveRoleBo saveRoleBo = new SaveRoleBo();
        //saveRoleBo.setRid(Long.parseLong(idgenValue));
        saveRoleBo.setRid(Long.parseLong(idgenValue));
        saveRoleBo.setName(saveRoleDto.getName());
        saveRoleBo.setNote(saveRoleDto.getNote());
        //创建人和修改人id要去session里面读取
        saveRoleBo.setCreateUser(1L);
        saveRoleBo.setCreateTime(LocalDate.now());
        saveRoleBo.setUpdateUser(1L);
        saveRoleBo.setUpdateTime(LocalDate.now());
        if (roleService.saveRole(saveRoleBo) >= 1){return GenericRspDTO.newInstance(MsgEnum.SUCCESS);}
        return GenericRspDTO.newInstance(MsgEnum.FAIL);
    }

    /**
     * 修改用户信息
     * @param updateRoleDto
     * @return
     */
    @PostMapping("/update")
    public GenericRspDTO<NoBody> updateRole(@RequestBody UpdateRoleDto updateRoleDto){
        UpdateRoleBo updateRoleBo = new UpdateRoleBo();
        updateRoleBo.setRid(updateRoleDto.getRid());
        updateRoleBo.setName(updateRoleDto.getName());
        updateRoleBo.setNote(updateRoleDto.getNote());
        //通过session读取当前用户为修改人
        updateRoleBo.setUpdateUser(1L);
        updateRoleBo.setUpdateTime(LocalDate.now());
        if (roleService.updateRole(updateRoleBo) == 1){return GenericRspDTO.newInstance(MsgEnum.SUCCESS);}
        return GenericRspDTO.newInstance(MsgEnum.FAIL);
    }

    /**
     * 批量删除角色信息
     * @param deleteRoleDto
     * @return
     */
    @DeleteMapping("/delete")
    public GenericRspDTO<NoBody> deleteRole(@RequestBody DeleteRoleDto deleteRoleDto){
        DeleteRoleBo deleteRoleBo = new DeleteRoleBo();
        deleteRoleBo.setDelList(deleteRoleDto.getDelList());
        if (roleService.deleteRole(deleteRoleBo) >= 1){return GenericRspDTO.newInstance(MsgEnum.SUCCESS);}
        return GenericRspDTO.newInstance(MsgEnum.FAIL);
    }
}
