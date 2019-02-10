package com.rlws.plant.web.admin.service.impl;

import com.rlws.plant.domain.User;
import com.rlws.plant.web.admin.service.UserService;
import com.rlws.plant.web.admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User selectByPrimaryKey(String email) {
        System.out.println("121212121212"+email);
        User user = userMapper.selectByPrimaryKey(email);
        return user;
    }

}
