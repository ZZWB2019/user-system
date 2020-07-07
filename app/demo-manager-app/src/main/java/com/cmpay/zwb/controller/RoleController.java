package com.cmpay.zwb.controller;

import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.common.utils.RandomUtils;
import com.cmpay.lemon.framework.data.NoBody;
import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.zwb.bo.*;
import com.cmpay.zwb.dto.*;
import com.cmpay.zwb.entity.RoleDO;
import com.cmpay.zwb.enums.MsgEnum;
import com.cmpay.zwb.service.RoleMenuService;
import com.cmpay.zwb.service.RoleService;
import com.cmpay.zwb.util.BeanConvertUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouwb
 */
@RestController
@RequestMapping("/v1/ui-template/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @Resource
    private RoleMenuService roleMenuService;

    /**
     * 查询角色信息
     * @param simpRoleDto
     * @return
     */
    @PostMapping("/list")
    public GenericRspDTO<SelectRoleRsDTO> findRole(@RequestBody SimpRoleDto simpRoleDto){
        SelectRoleBo selectRoleBo = new SelectRoleBo();
        selectRoleBo.setName(simpRoleDto.getName());
        selectRoleBo.setPageNum(simpRoleDto.getPageNum());
        selectRoleBo.setPageSize(simpRoleDto.getPageSize());
        PageInfo<RoleDO> page = roleService.findPRole(selectRoleBo);

        List<RoleDto> roleDOS = BeanConvertUtils.convertList(page.getList(), RoleDto.class);
        SelectRoleRsDTO selectRoleRsDTO = new SelectRoleRsDTO();
        selectRoleRsDTO.setList(roleDOS);
        selectRoleRsDTO.setPageNum(page.getPageNum());
        selectRoleRsDTO.setPageSize(page.getPageSize());
        selectRoleRsDTO.setPages(page.getPages());
        selectRoleRsDTO.setTotal(page.getTotal());
        selectRoleRsDTO.setMsgCd(MsgEnum.SUCCESS.getMsgCd());
        selectRoleRsDTO.setMsgInfo(MsgEnum.SUCCESS.getMsgInfo());
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,selectRoleRsDTO);
    }

    /**
     * 初始化角色查询
     * @return
     */
    @GetMapping("/select")
    public GenericRspDTO<List<RoleDto>> listRole(){
         List<RoleDO> roleDOS = roleService.findRole(null);
        List<RoleDto> roleDtos = roleService.listFromate(roleDOS);
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,roleDtos);
    }

    /**
     * 通过id查询角色信息
     * @param id
     * @return
     */
    @GetMapping("/info/{id}")
    public GenericRspDTO<SelectRoleInfoDTO> getRole(@PathVariable("id") Long id){
        RoleDO roleDO = roleService.getByid(id);
        SelectRoleInfoDTO selectRoleInfoDTO = new SelectRoleInfoDTO();
        selectRoleInfoDTO.setName(roleDO.getName());
        selectRoleInfoDTO.setRid(roleDO.getRid());
        selectRoleInfoDTO.setNote(roleDO.getNote());
        List<Long> menuIds = roleMenuService.listMenuByRid(id);
        if (menuIds.isEmpty()){menuIds = new ArrayList<Long>();}
        selectRoleInfoDTO.setMenuIds(menuIds);
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,selectRoleInfoDTO);
    }

    /**
     * 添加角色信息
     * @param saveRoleDto
     * @return
     */
    @PostMapping("/save")
    public GenericRspDTO<NoBody> saveRole(@Validated @RequestBody SaveRoleDto saveRoleDto){
        String idgenValue = IdGenUtils.generateId("ZHOU_ROLE_IDGEN");
        SaveRoleBo saveRoleBo = new SaveRoleBo();
        saveRoleBo.setRid(Long.parseLong(idgenValue));
        saveRoleBo.setName(saveRoleDto.getName());
        saveRoleBo.setNote(saveRoleDto.getNote());
        //创建人和修改人id要去session里面读取
        saveRoleBo.setCreateUser(1L);
        saveRoleBo.setCreateTime(LocalDate.now());
        saveRoleBo.setUpdateUser(1L);
        saveRoleBo.setUpdateTime(LocalDate.now());
        //处理关联
        int tag = 0;
        SaveRoleMenuBo saveRoleMenuBo = new SaveRoleMenuBo();
        saveRoleMenuBo.setId(Long.valueOf(RandomUtils.nextInt()));
        saveRoleMenuBo.setRid(saveRoleBo.getRid());
        saveRoleMenuBo.setMids(saveRoleDto.getMenuIdList());
        tag = roleMenuService.saveRoleMenu(saveRoleMenuBo);

        if (roleService.saveRole(saveRoleBo) >= 1 && tag == 1){return GenericRspDTO.newInstance(MsgEnum.SUCCESS);}
        return GenericRspDTO.newInstance(MsgEnum.FAIL);
    }

    /**
     * 修改用户信息
     * @param updateRoleDto
     * @return
     */
    @PostMapping("/update")
    public GenericRspDTO<NoBody> updateRole(@Validated @RequestBody UpdateRoleDto updateRoleDto){
        UpdateRoleBo updateRoleBo = new UpdateRoleBo();
        updateRoleBo.setRid(updateRoleDto.getRid());
        updateRoleBo.setName(updateRoleDto.getName());
        updateRoleBo.setNote(updateRoleDto.getNote());
        //通过session读取当前用户为修改人
        updateRoleBo.setUpdateUser(1L);
        updateRoleBo.setUpdateTime(LocalDate.now());
        //判断关联操作是否成功
        int tag = 0;
        //处理关联关系
        if (roleMenuService.listMenuByRid(updateRoleDto.getRid()) == null){
            //添加关联
            SaveRoleMenuBo saveRoleMenuBo = new SaveRoleMenuBo();
            saveRoleMenuBo.setId(Long.valueOf(RandomUtils.nextInt()));
            saveRoleMenuBo.setMids(updateRoleDto.getMenuIdList());
            saveRoleMenuBo.setRid(updateRoleDto.getRid());
            tag = roleMenuService.saveRoleMenu(saveRoleMenuBo);
        }else{
            //修改关联
            UpdateRoleMenuBO updateRoleMenuBO = new UpdateRoleMenuBO();
            updateRoleMenuBO.setMids(updateRoleDto.getMenuIdList());
            updateRoleMenuBO.setRid(updateRoleDto.getRid());
            tag = roleMenuService.updateRoleMenu(updateRoleMenuBO);
        }
        if (roleService.updateRole(updateRoleBo) == 1 & tag > 0){return GenericRspDTO.newInstance(MsgEnum.SUCCESS);}
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
