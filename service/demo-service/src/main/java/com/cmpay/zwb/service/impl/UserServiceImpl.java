package com.cmpay.zwb.service.impl;

import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.zwb.bo.*;
import com.cmpay.zwb.dao.IUserDao;
import com.cmpay.zwb.dto.UserDto;
import com.cmpay.zwb.entity.UserDO;
import com.cmpay.zwb.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

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
        System.out.println(id);
        UserDO userDO = iUserDao.getById(id);
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
        userDO.setUid(idgenValue);
        LocalDate now = LocalDate.now();
        //userDO.setUid(6L);
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
        UserDO userDO = iUserDao.getByLogin(userInfoBo.getUsername(),userInfoBo.getPassword());
        SimpUserInfoBo simpUserInfoBo = new SimpUserInfoBo();
        simpUserInfoBo.setUsername(userDO.getName());
        simpUserInfoBo.setPassword(userDO.getPasswd());
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

        while (it.hasNext()) {
            UserDto roleDto = new UserDto();
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
        //userDO.setIsDeleted(deleteUserBo.getIsDeleted());
        userDO.setIsDel(Byte.parseByte("1"));
        userDO.setUid(deleteUserBo.getUid());
        return iUserDao.updateUserInfo(userDO);
    }

    /**
     * 修改用户信息
     * @param updateUserBo
     * @return
     */
    @Override
    public int updateUser(UpdateUserBo updateUserBo) {
        UserDO userDO = new UserDO();
        userDO.setUid(updateUserBo.getUid());
        userDO.setName(updateUserBo.getName());
        userDO.setPasswd(updateUserBo.getPasswd());
        userDO.setPhnumber(updateUserBo.getPhnumber());
        userDO.setEmail(updateUserBo.getEmail());
        userDO.setUserName(updateUserBo.getName());
        userDO.setIsDeleted(updateUserBo.getIsDelte());
        userDO.setUpdateUser(updateUserBo.getUpdateUser());
        userDO.setUpdateTime(updateUserBo.getUpdateTime());
        return iUserDao.updateUserInfo(userDO);
    }

    /**
     * 分页查询
     * @param selectUserBo
     * @return
     */
    @Override
    public PageInfo<UserDO> findPUser(SelectUserBo selectUserBo) {
        UserDO userDO = new UserDO();
        userDO.setName(selectUserBo.getUserName());
        return PageUtils.pageQueryWithCount(selectUserBo.getPageNum(),selectUserBo.getPageSize(),()->iUserDao.find(userDO));
    }
}
