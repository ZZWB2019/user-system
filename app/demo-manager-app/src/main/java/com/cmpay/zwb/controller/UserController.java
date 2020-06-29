package com.cmpay.zwb.controller;

import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.lemon.framework.security.SecurityUtils;
import com.cmpay.lemon.framework.security.UserInfoBase;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.zwb.bo.DeleteUserBo;
import com.cmpay.zwb.bo.SaveUserBo;
import com.cmpay.zwb.bo.UpdateUserBo;
import com.cmpay.zwb.dto.*;
import com.cmpay.zwb.entity.RoleDO;
import com.cmpay.zwb.entity.UserDO;
import com.cmpay.zwb.enums.MsgEnum;
import com.cmpay.zwb.service.RoleService;
import com.cmpay.zwb.service.UserService;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.BeanUtils;
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
//@RequestMapping("/user")
public class UserController {

    /**
     * 用户业务类
     */
    @Resource
    private UserService userService;

    /**
     * 角色业务类
     */
    @Resource
    private RoleService roleService;

    /**
     * 验证码工具
     */
    @Resource
    private DefaultKaptcha defaultKaptcha;

    @GetMapping("/v1/ui-template/user/info")
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
    @PostMapping("/v1/ui-template/user/list")
    public GenericRspDTO<InitRsUserDto> init(){
        List<UserDO> userDOS = PageUtils.pageQuery(1,4,() -> { return this.userService.findUser(null);});
        List<RoleDO> roleDOS = roleService.findRole(null);
        InitRsUserDto initRsUserDto = new InitRsUserDto(userService.ListFromate(userDOS));
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,initRsUserDto);
    }

    /**
     * 添加用户
     * @return
     */
    @PostMapping("/user/save")
    public Object saveUser(@QueryBody SaveUserDto saveUserDto){

        String idgenValue = IdGenUtils.generateId("ZHOU_USER_IDGEN");
        SaveUserBo saveUserBo = new SaveUserBo();
        BeanUtils.copyProperties(saveUserDto,saveUserBo);
        String msg = "no";
        if (userService.SaveUser(saveUserBo,null)==1){msg="yes";}
        return msg;
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
    @GetMapping("/user/getByid/{id}")
    public GenericRspDTO<ToUpdateRsUserDto> toUpdate(@PathVariable("id") Long id){
        UserDto userDto = new UserDto();
        UserDO userDO = userService.getUserById(id);
        BeanUtils.copyProperties(userDO,userDto);
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,new ToUpdateRsUserDto(userDto)) ;
    }

    /**
     * 禁用
     * @param deleteUserDto
     * @return
     */
    @PostMapping("/user/disable")
    public String disbaleUser(@RequestBody DeleteUserDto deleteUserDto){
        String msg = "no";
        DeleteUserBo deleteUserBo = new DeleteUserBo();
        deleteUserBo.setUid(deleteUserDto.getUid());
        deleteUserBo.setIsDeleted(deleteUserDto.getIsDelete());
        if (userService.isDelete(deleteUserBo) == 1){ msg = "yes";}
        return msg;
    }

    @PostMapping("/user/update")
    public String updateUser(@RequestBody UserUpdateDto userUpdateDto){
        String msg = "no";
        UpdateUserBo updateUserBo = new UpdateUserBo();
        updateUserBo.setUid(userUpdateDto.getUid());
        updateUserBo.setName(userUpdateDto.getName());
        updateUserBo.setPasswd(userUpdateDto.getPasswd());
        updateUserBo.setPhnumber(userUpdateDto.getPhnumber());
        updateUserBo.setEmail(userUpdateDto.getEmail());
        updateUserBo.setUserName(userUpdateDto.getUserName());
        //通过session拿到当前用户的信息
        updateUserBo.setUpdateUser(1L);
        updateUserBo.setUpdateTime(LocalDate.now());
        if (userService.updateUser(updateUserBo) == 1){msg = "yes";}
        return msg;
    }

    /**
     * 查询
     * @param selectUserDto
     * @return
     */
    @PostMapping("/user/select")
    public GenericRspDTO<List<UserDto>> selectUser(@RequestBody SelectUserDto selectUserDto){
        UserDO userDO = new UserDO();
        userDO.setName(selectUserDto.getName());
        userDO.setUserName(selectUserDto.getUserName());
        List<UserDO> userDOS = PageUtils.pageQuery(1,4,() -> { return this.userService.findUser(userDO);});
        List<UserDto> list = userService.ListFromate(userDOS);
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,list);
    }
}
