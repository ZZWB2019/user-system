package com.cmpay.zwb.service.impl;

import com.cmpay.zwb.bo.DeleteUserBo;
import com.cmpay.zwb.bo.SaveUserBo;
import com.cmpay.zwb.bo.SimpUserInfoBo;
import com.cmpay.zwb.dao.IUserDao;
import com.cmpay.zwb.dto.UserDto;
import com.cmpay.zwb.entity.UserDO;
import com.cmpay.zwb.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.Transient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhouwb
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private IUserDao iUserDao;

    /**
     * 测试id查询
     * @return
     */
    @Override
    public UserDO getUserById(Long id) {
        UserDO userDO = iUserDao.getById(id);
        userDO.setPasswd("*************");
        return userDO;
    }

    /**
     * 插入用户信息
     * @param saveUserBo
     * @param idgenValue
     * @return
     */
    @Override
    @Transient
    public int SaveUser(SaveUserBo saveUserBo, Long idgenValue) {
        UserDO userDO = new UserDO();
        //userDO.setUid(idgenValue);
        LocalDate now = LocalDate.now();
        userDO.setUid(6L);
        userDO.setName(saveUserBo.getName());
        userDO.setPasswd(saveUserBo.getPasswd());
        userDO.setPhnumber(saveUserBo.getPhnumber());
        userDO.setEmail(saveUserBo.getEmail());
        userDO.setCreateUser(1L);
        userDO.setCreateTime(now);
        userDO.setUpdateUser(1L);
        userDO.setUpdateTime(now);
        userDO.setUserName(saveUserBo.getUserName());
        return iUserDao.insert(userDO);
    }

    /**
     * 登录业务代码
     * @param userInfoBo
     * @return
     */
    @Override
    public SimpUserInfoBo login(SimpUserInfoBo userInfoBo) {
        UserDO userDO = iUserDao.getByLogin(userInfoBo.getName(),userInfoBo.getPasswd());
        SimpUserInfoBo simpUserInfoBo = new SimpUserInfoBo();
        simpUserInfoBo.setName(userDO.getName());
        simpUserInfoBo.setPasswd(userDO.getPasswd());
        simpUserInfoBo.setUid(userDO.getUid());
        return simpUserInfoBo;
    }

    /**
     * 查询用户的信息
     * @param userDO
     * @return
     */
    @Override
    public List<UserDO> findUser(UserDO userDO) {
        return iUserDao.find(userDO);
    }

    /**
     * 转换格式
     * @param userDOS
     * @return
     */
    @Override
    public List<UserDto> ListFromate(List<UserDO> userDOS) {
        Iterator<UserDO> it = userDOS.iterator();
        List<UserDto> list = new ArrayList<UserDto>();
        UserDto roleDto = new UserDto();
        while (it.hasNext()) {
            UserDO temp = it.next();
            BeanUtils.copyProperties(temp,roleDto);
            list.add(roleDto);
        }
        return list;
    }

    /**
     * 逻辑删除
     * @param deleteUserBo
     * @return
     */
    @Override
    @Transient
    public int isDelete(DeleteUserBo deleteUserBo) {
        UserDO userDO = new UserDO();
        userDO.setIsDeleted(deleteUserBo.getIsDeleted());
        userDO.setUid(deleteUserBo.getUid());
        return iUserDao.updateUserInfo(userDO);
    }
}
