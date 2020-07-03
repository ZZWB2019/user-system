package com.cmpay.zwb.service.impl;

import com.cmpay.zwb.bo.SaveUserRoleBo;
import com.cmpay.zwb.bo.UpdateUserRoleBo;
import com.cmpay.zwb.dao.IUserRoleDao;
import com.cmpay.zwb.entity.UserRoleDO;
import com.cmpay.zwb.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouwb
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private IUserRoleDao userRoleDao;

    /**
     * 通过角色id查询关联角色关联id
     * @param uid
     * @return
     */
    @Override
    public List<Long> ListRidByUid(Long uid) {
        UserRoleDO userRoleDO = userRoleDao.getByUid(uid);
        if (userRoleDO == null){return null;}
        List<Long> list = new ArrayList<Long>();
        String[] strs = userRoleDO.getRids().split(",");
        for ( String tem : strs) {
            list.add(Long.parseLong(tem));
        }
        return list;
    }

    /**
     * 添加用户角色关联
     * @param saveUserRoleBo
     * @return
     */
    @Override
    public int addUserRole(SaveUserRoleBo saveUserRoleBo) {
        UserRoleDO userRoleDO = new UserRoleDO();
        userRoleDO.setId(saveUserRoleBo.getId());
        userRoleDO.setUid(saveUserRoleBo.getUid());
        StringBuffer strbuffer = new StringBuffer();
        for (Long tem : saveUserRoleBo.getRids()) {
            strbuffer.append(tem);
            strbuffer.append(",");
        }
        userRoleDO.setRids(strbuffer.toString());
        return userRoleDao.insert(userRoleDO);
    }

    /**
     * 修改角色用户关联
     * @param updateUserRoleBo
     * @return
     */
    @Override
    public int updateUserRole(UpdateUserRoleBo updateUserRoleBo) {
        UserRoleDO userRoleDO = new UserRoleDO();
        userRoleDO.setUid(updateUserRoleBo.getUid());
        StringBuffer strBuff = new StringBuffer();
        for (Long tem : updateUserRoleBo.getRids()) {
            strBuff.append(tem);
            strBuff.append(",");
        }
        userRoleDO.setRids(strBuff.toString());
        return userRoleDao.updataUserRol(userRoleDO);
    }


}
