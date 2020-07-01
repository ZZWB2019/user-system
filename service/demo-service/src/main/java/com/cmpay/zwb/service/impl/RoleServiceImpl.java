package com.cmpay.zwb.service.impl;

import com.cmpay.zwb.bo.DeleteRoleBo;
import com.cmpay.zwb.bo.SaveRoleBo;
import com.cmpay.zwb.bo.SimpRoleBo;
import com.cmpay.zwb.bo.UpdateRoleBo;
import com.cmpay.zwb.dao.IRoleDao;
import com.cmpay.zwb.dto.RoleDto;
import com.cmpay.zwb.entity.RoleDO;
import com.cmpay.zwb.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhouwb
 * 角色业务类
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private IRoleDao roleDao;

    /**
     * 查询角色信息
     * @return
     */
    @Override
    public List<RoleDO> findRole(SimpRoleBo simpRoleBo) {
        if (simpRoleBo == null){
            return roleDao.find(null);
        }
        RoleDO roleDO = new RoleDO();
        roleDO.setName(simpRoleBo.getName());
        roleDO.setRid(simpRoleBo.getRid());
        return roleDao.find(roleDO);
    }

    /**
     * 格式转换类
     * @param doList
     * @return
     */
    @Override
    public List<RoleDto> listFromate(List<RoleDO> doList) {

        Iterator<RoleDO> it = doList.iterator();
        List<RoleDto> list = new ArrayList<RoleDto>();

        while (it.hasNext()) {
            RoleDto roleDto = new RoleDto();
            RoleDO temp = it.next();
            BeanUtils.copyProperties(temp,roleDto);
            list.add(roleDto);
        }
        return list;
    }

    /**
     * 通过id查询角色信息
     * @param id
     * @return
     */
    @Override
    public RoleDto getByid(Long id) {
        RoleDO roleDO = roleDao.getById(id);
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(roleDO,roleDto);
        return roleDto;
    }

    /**
     * 添加角色信息
     * @param saveRoleBo
     * @return
     */
    @Override
    public int saveRole(SaveRoleBo saveRoleBo) {
        RoleDO roleDO = new RoleDO();
        BeanUtils.copyProperties(saveRoleBo,roleDO);
        return roleDao.insert(roleDO);
    }

    /**
     * 修改用户信息
     * @param updateRoleBo
     * @return
     */
    @Override
    public int updateRole(UpdateRoleBo updateRoleBo) {
        RoleDO roleDO = new RoleDO();
        roleDO.setRid(updateRoleBo.getRid());
        roleDO.setName(updateRoleBo.getName());
        roleDO.setNote(updateRoleBo.getNote());
        roleDO.setUpdateUser(updateRoleBo.getUpdateUser());
        roleDO.setUpdateTime(updateRoleBo.getUpdateTime());
        return roleDao.updateRole(roleDO);
    }

    /**
     * 批量删除角色信息
     * @param deleteRoleBo
     * @return
     */
    @Override
    public int deleteRole(DeleteRoleBo deleteRoleBo) {
        return roleDao.deleteRole(deleteRoleBo.getDelList());
    }
}
