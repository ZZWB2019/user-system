package com.cmpay.zwb.service.impl;

import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.zwb.bo.*;
import com.cmpay.zwb.dao.IRoleDao;
import com.cmpay.zwb.dto.RoleDto;
import com.cmpay.zwb.entity.RoleDO;
import com.cmpay.zwb.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    public RoleDO getByid(Long id) {
        return roleDao.getById(id);
    }

    /**
     * 添加角色信息
     * @param saveRoleBo
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
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
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
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
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteRole(DeleteRoleBo deleteRoleBo) {
        return roleDao.deleteRole(deleteRoleBo.getDelList());
    }

    /**
     * 分页查询角色信息
     * @param selectRoleBo
     * @return
     */
    @Override
    public PageInfo<RoleDO> findPRole(SelectRoleBo selectRoleBo) {
        RoleDO roleDO = new RoleDO();
        roleDO.setName(selectRoleBo.getName());
        return PageUtils.pageQueryWithCount(selectRoleBo.getPageNum(),selectRoleBo.getPageSize(),() -> {return this.roleDao.find(roleDO);});
    }
}
