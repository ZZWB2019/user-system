package com.cmpay.zwb.controller;

import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.zwb.bo.SaveUserBo;
import com.cmpay.zwb.dto.*;
import com.cmpay.zwb.entity.UserDO;
import com.cmpay.zwb.enums.MsgEnum;
import com.cmpay.zwb.service.UserService;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.thoughtworks.xstream.core.ReferenceByIdMarshaller;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    UserService userService;

    /**
     * 验证码工具
     */
    @Resource
    DefaultKaptcha defaultKaptcha;

    /**
     * 初始化页面查询
     * @return
     */
    @GetMapping("/user/info")
    public GenericRspDTO<List<UserDO>> init(){
        List<UserDO> list = PageUtils.pageQuery(1,2,() -> { return this.userService.findUser(null);});
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,list);
    }

    /**
     * 添加用户
     * @return
     */
    @PostMapping("/user/save")
    public Object saveUser(@QueryBody SaveUserDto saveUserDto){
        //String idgenValue = IdGenUtils.generateId("ZHOU_USER_IDGEN");
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
    @PostMapping("/user/to_update")
    public ToUpdateRsUserDto toUpdate(@QueryBody() Long id){
        UserDto userDto = new UserDto();
        System.out.println(id);
        UserDO userDO = userService.getUserById(id);
        BeanUtils.copyProperties(userDO,userDto);
        return new ToUpdateRsUserDto(userDto);
    }


}
