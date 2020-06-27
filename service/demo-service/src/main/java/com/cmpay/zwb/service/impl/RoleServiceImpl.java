package com.cmpay.zwb.service.impl;

import com.cmpay.zwb.bo.SimpRoleBo;
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
}
