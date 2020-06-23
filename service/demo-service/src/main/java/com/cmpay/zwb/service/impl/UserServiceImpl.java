package com.cmpay.zwb.service.impl;

import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.zwb.bo.SaveUserBo;
import com.cmpay.zwb.bo.SimpUserInfoBo;
import com.cmpay.zwb.dao.IUserDao;
import com.cmpay.zwb.dto.InitRsUserDto;
import com.cmpay.zwb.dto.InitUserDto;
import com.cmpay.zwb.dto.SaveUserDto;
import com.cmpay.zwb.entity.UserDO;
import com.cmpay.zwb.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.Transient;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author zhouwb
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private IUserDao iUserDao;

    /**
     * 分页查询
     * @return
     */
    @Override
    public List<InitUserDto> ListByPage() {
        return null;
    }

    /**
     * 测试id查询
     * @return
     */
    @Override
    public UserDO getUserById(Long id) {
        UserDO userDO = iUserDao.getById(id);
        //PageUtils.pageQueryWithCount();
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
        userDO.setUid(4L);
        userDO.setName(saveUserBo.getName());
        userDO.setPasswd(saveUserBo.getPasswd());
        userDO.setPhnumber(saveUserBo.getPhnumber());
        userDO.setEmail(saveUserBo.getEmail());
        userDO.setCreateUser(1L);
        userDO.setCreateTime(now);
        userDO.setUpdateUser(1L);
        userDO.setUpdateTime(now);
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
}
