package com.cmpay.zwb.service;

import com.cmpay.zwb.bo.SaveUserRoleBo;
import com.cmpay.zwb.bo.UpdateUserRoleBo;

import java.util.List;

/**
 * @author zhouwb
 */
public interface UserRoleService {
    /**
     * 通过角色id查询关联角色关联id
     * @param uid
     * @return
     */
    public List<Long> ListRidByUid(Long uid);

    /**
     * 绑定用户与角色关系
     * @param saveUserRoleBo
     * @return
     */
    public int addUserRole(SaveUserRoleBo saveUserRoleBo);

    /**
     * 修改角色用户关联信息
     * @param updateUserRoleBo
     * @return
     */
    public int updateUserRole(UpdateUserRoleBo updateUserRoleBo);
}
