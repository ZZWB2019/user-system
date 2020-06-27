package com.cmpay.zwb.service;

import com.cmpay.zwb.bo.SaveRoleBo;
import com.cmpay.zwb.bo.SimpRoleBo;
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
    public List<RoleDO> findRole(SimpRoleBo simpRoleBo);

    /**
     * 转换List<RoleDO> 成 List<RoleDto>
     * @param doList
     * @return
     */
    public List<RoleDto> listFromate(List<RoleDO> doList);

    /**
     * 通过id查询角色信息
     * @param id
     * @return
     */
    public RoleDto getByid(Long id);

    /**
     * 添加角色
     * @param saveRoleBo
     * @return
     */
    public int saveRole(SaveRoleBo saveRoleBo);
}
