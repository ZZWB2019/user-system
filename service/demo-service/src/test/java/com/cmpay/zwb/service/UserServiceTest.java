package com.cmpay.zwb.service;


import com.cmpay.zwb.dao.IUserDao;
import com.cmpay.zwb.entity.UserDO;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserServiceTest{

    @Resource
    private IUserDao dao;

    @Test
    public void test(){
        UserDO userDO = dao.get(1l);
        System.out.println(userDO);
    }
}
