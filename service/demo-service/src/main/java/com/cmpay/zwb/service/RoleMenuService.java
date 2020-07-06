package com.cmpay.zwb.service;

import com.cmpay.zwb.bo.SaveRoleMenuBo;
import com.cmpay.zwb.bo.UpdateRoleMenuBO;

import java.util.List;

/**
 * @author zhouwb
 */
public interface RoleMenuService {

    /**
     * 通过角色id查询菜单权限
     * @param rid
     * @return
     */
    public List<Long> listMenuByRid(Long rid);

    /**
     * 添加关联
     * @param saveRoleMenuBo
     * @return
     */
    public int saveRoleMenu(SaveRoleMenuBo saveRoleMenuBo);

    /**
     * 修改关联
     * @param updateRoleMenuBO
     * @return
     */
    public int updateRoleMenu(UpdateRoleMenuBO updateRoleMenuBO);
}
