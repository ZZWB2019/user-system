package com.cmpay.zwb.service.impl;

import com.cmpay.lemon.framework.utils.PageUtils;
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
     * @param saveUserDto
     * @param idgenValue
     * @return
     */
    @Override
    @Transient
    public int SaveUser(SaveUserDto saveUserDto,Long idgenValue) {
        UserDO userDO = new UserDO();
        //userDO.setUid(idgenValue);
        userDO.setUid(2L);
        userDO.setName(saveUserDto.getName());
        userDO.setPasswd(saveUserDto.getPasswd());
        userDO.setPhnumber(saveUserDto.getPhnumber());
        userDO.setEmail(saveUserDto.getEmail());
        userDO.setCreateTime(LocalDate.now());
        return iUserDao.insert(userDO);
    }

    @Override
    public UserDO login(String name, String passwd) {

        return null;
    }
}
