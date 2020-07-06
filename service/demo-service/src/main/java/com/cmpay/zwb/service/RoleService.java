package com.cmpay.zwb.service;

import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.zwb.bo.*;
import com.cmpay.zwb.dto.RoleDto;
import com.cmpay.zwb.entity.RoleDO;

import java.util.List;

/**
 * @author zhouwb
 */
public interface RoleService {
    /**
     * 查询当前的所有的角色
     * @return
     */
    List<RoleDO> findRole(SimpRoleBo simpRoleBo);

    /**
     * 转换List<RoleDO> 成 List<RoleDto>
     * @param doList
     * @return
     */
    List<RoleDto> listFromate(List<RoleDO> doList);

    /**
     * 通过id查询角色信息
     * @param id
     * @return
     */
    RoleDO getByid(Long id);

    /**
     * 添加角色
     * @param saveRoleBo
     * @return
     */
    int saveRole(SaveRoleBo saveRoleBo);

    /**
     * 修改角色信息
     * @param updateRoleBo
     * @return
     */
    int updateRole(UpdateRoleBo updateRoleBo);

    /**
     * 批量删除角色信息
     * @param deleteRoleBo
     * @return
     */
    int deleteRole(DeleteRoleBo deleteRoleBo);

    /**
     * 分页查询角色信息
     * @param selectRoleBo
     * @return
     */
    PageInfo<RoleDO> findPRole(SelectRoleBo selectRoleBo);
}
