package com.yang.hrms.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sunyang
 * @date 2018/5/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void pageUserTest(){
        System.out.println(userService.pageUser(null,null).getTotalRecords());
    }
}
