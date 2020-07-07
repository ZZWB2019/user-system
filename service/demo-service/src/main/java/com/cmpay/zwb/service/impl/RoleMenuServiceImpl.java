package com.cmpay.zwb.service.impl;

import com.cmpay.lemon.common.utils.StringUtils;
import com.cmpay.zwb.bo.SaveRoleMenuBo;
import com.cmpay.zwb.bo.UpdateRoleMenuBO;
import com.cmpay.zwb.dao.IRoleMenuDao;
import com.cmpay.zwb.entity.RoleMenuDO;
import com.cmpay.zwb.service.RoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouwb
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Resource
    private IRoleMenuDao roleMenuDao;

    /**
     * 通过rid查询角色关联的mid信息
     * @param rid
     * @return
     */
    @Override
    public List<Long> listMenuByRid(Long rid) {
        RoleMenuDO roleMenuDOS = roleMenuDao.listByRid(rid);
        List<Long> list = new ArrayList<Long>();
        if (roleMenuDOS == null){return null;}
        for (String tem : roleMenuDOS.getMids().split(",")) {
            list.add(Long.parseLong(tem));
        }
        return list;
    }

    /**
     * 添加关联
     * @param saveRoleMenuBo
     * @return
     */
    @Override
    public int saveRoleMenu(SaveRoleMenuBo saveRoleMenuBo) {
        RoleMenuDO roleMenuDO = new RoleMenuDO();
        roleMenuDO.setId(saveRoleMenuBo.getId());
        roleMenuDO.setRid(saveRoleMenuBo.getRid());
        roleMenuDO.setMids(StringUtils.join(saveRoleMenuBo.getMids(), ","));
        return roleMenuDao.insert(roleMenuDO);
    }

    /**
     * 修改关联信息
     * @param updateRoleMenuBO
     * @return
     */
    @Override
    public int updateRoleMenu(UpdateRoleMenuBO updateRoleMenuBO) {
        RoleMenuDO roleMenuDO = new RoleMenuDO();
        roleMenuDO.setRid(updateRoleMenuBO.getRid());
        roleMenuDO.setMids(StringUtils.join(updateRoleMenuBO.getMids(), ","));
        return roleMenuDao.updateByRid(roleMenuDO);
    }
}