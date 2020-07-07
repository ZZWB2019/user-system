package com.cmpay.zwb.service;

import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.zwb.bo.*;
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
    UserDO getUserById(Long id);

    /**
     * 插入一个用户信息
     * @param saveUserBo
     * @return
     */
    int saveUser(SaveUserBo saveUserBo, Long idgenValue);

    /**
     * 用户登录
     * @param userInfoBo
     * @return
     */
    SimpUserInfoBo login(SimpUserInfoBo userInfoBo);

    /**
     * 查询用户字段
     * @return
     */
    List<UserDO> findUser(UserDO userDO);

    /**
     * 转换List<UserDO> 成 List<UserDto>
     * @return
     */
    List<UserDto> ListFromate(List<UserDO> userDOS);

    /**
     * 修改用户为禁用
     * @param deleteUserBo
     * @return
     */
    int isDelete(DeleteUserBo deleteUserBo);

    /**
     * 修改用户信息
     * @param updateUserBo
     * @return
     */
    int updateUser(UpdateUserBo updateUserBo);

    /**
     * 分页查询
     * @param selectUserBo
     * @return
     */
    PageInfo<UserDO> findPUser(SelectUserBo selectUserBo);
}
