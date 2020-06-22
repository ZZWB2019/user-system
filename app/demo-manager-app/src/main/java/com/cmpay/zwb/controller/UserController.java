package com.cmpay.zwb.controller;

import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.zwb.bo.SaveUserBo;
import com.cmpay.zwb.bo.SimpUserInfoBo;
import com.cmpay.zwb.dto.*;
import com.cmpay.zwb.entity.UserDO;
import com.cmpay.zwb.enums.MsgEnum;
import com.cmpay.zwb.service.UserService;
import com.thoughtworks.xstream.core.ReferenceByIdMarshaller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author  zhouwb
 */
@RestController
//@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

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
        System.out.println(saveUserDto.getName());
        SaveUserBo saveUserBo = new SaveUserBo();
        BeanUtils.copyProperties(saveUserDto,saveUserBo);
        System.out.println(saveUserBo.getName());
        int result = userService.SaveUser(saveUserBo,null);
        return "Ok";
    }


}
