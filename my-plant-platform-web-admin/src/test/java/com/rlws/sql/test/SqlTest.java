package com.rlws.sql.test;

import com.rlws.plant.domain.User;
import com.rlws.plant.web.admin.service.UserService;
import com.rlws.plant.web.admin.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml","classpath:spring-mvc.xml",})
public class SqlTest {

    private UserService userService = new UserServiceImpl();

    @Test
    public void test(){
        User user = userService.selectByPrimaryKey("123@qq.com");
        System.out.println(user);
    }
}
