package com.cmpay.zwb.service;

import com.cmpay.zwb.bo.SaveUserBo;
import com.cmpay.zwb.bo.SimpUserInfoBo;
import com.cmpay.zwb.dao.IUserDao;
import com.cmpay.zwb.dto.InitRsUserDto;
import com.cmpay.zwb.dto.InitUserDto;
import com.cmpay.zwb.dto.SaveUserDto;
import com.cmpay.zwb.entity.UserDO;
import org.apache.catalina.User;

import java.util.List;

/**
 * @author  zhouwb
 */
public interface UserService {

    /**
     * 查询
     * @return
     */
    public List<InitUserDto> ListByPage();

    /**
     * 通过id查询
     * @return
     */
    public UserDO getUserById(Long id);

    /**
     * 插入一个用户信息
     * @param saveUserBo
     * @return
     */
    public int SaveUser(SaveUserBo saveUserBo, Long idgenValue);

    /**
     * 用户登录
     * @param userInfoBo
     * @return
     */
    public SimpUserInfoBo login(SimpUserInfoBo userInfoBo);

    /**
     * 查询用户字段
     * @return
     */
    public List<UserDO> findUser(UserDO userDO);


}
