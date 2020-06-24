package com.cmpay.zwb.service;

import com.cmpay.zwb.bo.DeleteUserBo;
import com.cmpay.zwb.bo.SaveUserBo;
import com.cmpay.zwb.bo.SimpUserInfoBo;
import com.cmpay.zwb.dto.UserDto;
import com.cmpay.zwb.entity.UserDO;

import java.util.List;

/**
 * @author  zhouwb
 */
public interface UserService {
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

    /**
     * 转换List<UserDO> 成 List<UserDto>
     * @return
     */
    public List<UserDto> ListFromate(List<UserDO> userDOS);

    public int isDelete(DeleteUserBo deleteUserBo);
}
