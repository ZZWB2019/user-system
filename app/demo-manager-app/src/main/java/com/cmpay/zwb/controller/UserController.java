package com.cmpay.zwb.controller;

import com.cmpay.framework.data.request.GenericDTO;
import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.common.utils.RandomUtils;
import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.lemon.framework.data.NoBody;
import com.cmpay.lemon.framework.security.SecurityUtils;
import com.cmpay.lemon.framework.security.UserInfoBase;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.zwb.bo.*;
import com.cmpay.zwb.dto.*;
import com.cmpay.zwb.entity.RoleDO;
import com.cmpay.zwb.entity.UserDO;
import com.cmpay.zwb.enums.MsgEnum;
import com.cmpay.zwb.service.RoleService;
import com.cmpay.zwb.service.UserRoleService;
import com.cmpay.zwb.service.UserService;
import com.cmpay.zwb.util.BeanConvertUtils;
import com.github.pagehelper.PageInfo;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  zhouwb
 */
@RestController
//@Log4j2
@RequestMapping("/v1/ui-template")
public class UserController {

    /**
     * 用户业务类
     */
    @Resource
    private UserService userService;

    /**
     * 用户角色关联业务类
     */
    @Resource
    private UserRoleService userRoleService;

    /**
     * 验证码工具
     */
    @Resource
    private DefaultKaptcha defaultKaptcha;

    /**
     * 查询
     * @return
     */
    @GetMapping("/user/info")
    public GenericRspDTO<UserDto> getUserInfo(){
        UserInfoBase loginUser = SecurityUtils.getLoginUser();
        UserDO userById = userService.getUserById(Long.valueOf(loginUser.getUserId()));
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userById,userDto);
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,userDto);
    }


    /**
     * 初始化页面查询
     * @return
     */
    @PostMapping("/user/list")
    public GenericRspDTO<InitRsUserDto> selectUsers(@RequestBody SelectUserDto selectUserDto){
        SelectUserBo selectUserBo = new SelectUserBo();
        selectUserBo.setUserName(selectUserDto.getUserName());
        selectUserBo.setPageNum(selectUserDto.getPageNum());
        selectUserBo.setPageSize(selectUserDto.getPageSize());
        PageInfo<UserDO> page = userService.findPUser(selectUserBo);

        List<UserDto> userInfos = BeanConvertUtils.convertList(page.getList(), UserDto.class);
        InitRsUserDto initRsUserDto = new InitRsUserDto();
        initRsUserDto.setUserDtos(userInfos);
        initRsUserDto.setPageNum(page.getPageNum());
        initRsUserDto.setPageSize(page.getPageSize());
        initRsUserDto.setPages(page.getPages());
        initRsUserDto.setTotal(page.getTotal());
        initRsUserDto.setMsgCd(MsgEnum.SUCCESS.getMsgCd());
        initRsUserDto.setMsgInfo(MsgEnum.SUCCESS.getMsgInfo());
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,initRsUserDto);
    }

    /**
     * 添加用户
     * @return
     */
    @PostMapping("/user/save")
    public GenericRspDTO<NoBody> saveUser(@RequestBody SaveUserDto saveUserDto){
        String idgenValue = IdGenUtils.generateId("ZHOU_USER_IDGEN");
        //Long idgenValue = RandomUtils.nextLong(0,100000000);
        SaveUserBo saveUserBo = new SaveUserBo();
        saveUserBo.setName(saveUserDto.getName());
        saveUserBo.setEmail(saveUserDto.getEmail());
        saveUserBo.setPasswd(saveUserDto.getPasswd());
        saveUserBo.setPhnumber(saveUserDto.getPhnumber());
        //添加关联
        SaveUserRoleBo saveUserRoleBo = new SaveUserRoleBo();
        saveUserRoleBo.setId(Long.valueOf(RandomUtils.nextInt()));
        saveUserRoleBo.setUid(Long.parseLong(idgenValue));
        saveUserRoleBo.setRids(saveUserDto.getRoleIds());
        if (userService.SaveUser(saveUserBo,Long.parseLong(idgenValue))==1 & userRoleService.addUserRole(saveUserRoleBo) == 1){return GenericRspDTO.newInstance(MsgEnum.SUCCESS);}
        return GenericRspDTO.newInstance(MsgEnum.FAIL);
    }

    /**
     * 进入登录界面时生成验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/tologin")
    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        byte[] captcha = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            // 将生成的验证码保存在session中
            String createText = defaultKaptcha.createText();
            HttpSession session = request.getSession();
            session.setAttribute("rightCode", createText);
            //设置过期时间为180秒
            session.setMaxInactiveInterval(180);
            BufferedImage bi = defaultKaptcha.createImage(createText);
            ImageIO.write(bi, "jpg", out);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        captcha = out.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream sout = response.getOutputStream();
        sout.write(captcha);
        sout.flush();
        sout.close();
    }

    /**
     * 通过id查询用户的信息去往修改面板
     * @param id
     * @return
     */
    @GetMapping("/user/info/{id}")
    public GenericRspDTO<ToUpdateRsUserDto> toUpdate(@PathVariable("id") Long id){
        UserDto userDto = new UserDto();
        UserDO userDO = userService.getUserById(id);
        BeanUtils.copyProperties(userDO,userDto);
        List<Long> longs = userRoleService.ListRidByUid(id);
        if (longs == null){longs = new ArrayList<>();}
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,new ToUpdateRsUserDto(userDto,longs)) ;
    }

    /**
     * 逻辑删除
     * @param deleteUserDto
     * @return
     */
    @DeleteMapping("/user/delete")
    public GenericRspDTO<NoBody> disbaleUser(@RequestBody DeleteUserDto deleteUserDto){
        System.out.println(deleteUserDto);
        DeleteUserBo deleteUserBo = new DeleteUserBo();
        deleteUserBo.setDelList(deleteUserDto.getId());
        deleteUserBo.setIsDeleted(deleteUserDto.getIsDelete());
        if (userService.isDelete(deleteUserBo) >= 1){ return GenericRspDTO.newInstance(MsgEnum.SUCCESS);}
        return GenericRspDTO.newInstance(MsgEnum.FAIL);
    }

    /**
     * 修改用户信息
     * @param userUpdateDto
     * @return
     */
    @PostMapping("/user/update")
    public GenericRspDTO<NoBody> updateUser(@RequestBody UserUpdateDto userUpdateDto){
        UpdateUserBo updateUserBo = new UpdateUserBo();
        updateUserBo.setUid(userUpdateDto.getUid());
        updateUserBo.setName(userUpdateDto.getName());
        updateUserBo.setPasswd(userUpdateDto.getPasswd());
        updateUserBo.setPhnumber(userUpdateDto.getPhnumber());
        updateUserBo.setEmail(userUpdateDto.getEmail());
        updateUserBo.setUserName(userUpdateDto.getUserName());
        updateUserBo.setIsDelte(userUpdateDto.getIsDelete());
        //通过session拿到当前用户的信息
        updateUserBo.setUpdateUser(1L);
        updateUserBo.setUpdateTime(LocalDate.now());
        //判断关联关系修改
        int tag = 0;
        //修改关联
        if (userRoleService.ListRidByUid(userUpdateDto.getUid()) == null){
            //添加关联
            SaveUserRoleBo saveUserRoleBo = new SaveUserRoleBo();
            saveUserRoleBo.setId(Long.valueOf(RandomUtils.nextInt()));
            saveUserRoleBo.setUid(userUpdateDto.getUid());
            saveUserRoleBo.setRids(userUpdateDto.getRoleIds());
            tag = userRoleService.addUserRole(saveUserRoleBo);
        }else{
            //修改关联
            UpdateUserRoleBo updateUserRoleBo = new UpdateUserRoleBo();
            updateUserRoleBo.setRids(userUpdateDto.getRoleIds());
            updateUserRoleBo.setUid(userUpdateDto.getUid());
            tag = userRoleService.updateUserRole(updateUserRoleBo);
        }
        if (userService.updateUser(updateUserBo) == 1 && tag >= 1){return GenericRspDTO.newInstance(MsgEnum.SUCCESS);}
        return GenericRspDTO.newInstance(MsgEnum.FAIL);
    }

    /**
     * 查询
     * @param selectUserDto
     * @return
     */
    /*@PostMapping("/user/list")
    public GenericRspDTO<SelectUserRsDto> selectUser(@RequestBody SelectUserDto selectUserDto){
        UserDO userDO = new UserDO();
        userDO.setName(selectUserDto.getUserName());
        int pageNum;
        int pageSize;
        if (selectUserDto.getPageNum() == 0 || selectUserDto.getPageSize() == 0){
            pageNum = 1;
            pageSize = 10;
        }else{
            pageNum = selectUserDto.getPageNum();
            pageSize =selectUserDto.getPageSize();
        }
        List<UserDO> userDOS = PageUtils.pageQuery(pageNum,pageSize,() -> { return this.userService.findUser(userDO);});
        List<UserDto> list = userService.ListFromate(userDOS);
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,new SelectUserRsDto(list,pageNum,pageSize));
//        return null;
    }*/
}
