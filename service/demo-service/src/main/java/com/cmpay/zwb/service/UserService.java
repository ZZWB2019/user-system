package com.cmpay.zwb.service;

import com.cmpay.zwb.dao.IUserDao;
import com.cmpay.zwb.dto.InitRsUserDto;
import com.cmpay.zwb.dto.InitUserDto;
import com.cmpay.zwb.dto.SaveUserDto;
import com.cmpay.zwb.entity.UserDO;

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
     * @param saveUserDto
     * @return
     */
    public int SaveUser(SaveUserDto saveUserDto,Long idgenValue);
}
