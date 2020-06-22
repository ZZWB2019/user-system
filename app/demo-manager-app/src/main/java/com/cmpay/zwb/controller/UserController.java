package com.cmpay.zwb.controller;

import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.zwb.dto.InitRsUserDto;
import com.cmpay.zwb.dto.InitUserDto;
import com.cmpay.zwb.dto.SaveUserDto;
import com.cmpay.zwb.entity.UserDO;
import com.cmpay.zwb.service.UserService;
import com.thoughtworks.xstream.core.ReferenceByIdMarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author  zhouwb
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    /**
     * 初始化页面查询
     * @return
     */
    @GetMapping("/info")
    public Object init(){
        //List<InitRsUserDto> list = PageUtils.pageQuery();
        UserDO userDO = userService.getUserById(1L);
        return userDO;
    }

    @GetMapping("/save")
    public Object saveUser(){
        //String idgenValue = IdGenUtils.generateId("ZHOU_USER_IDGEN");
        //int result = userService.SaveUser(saveUserDto,null);
        return "Ok";
    }
}
