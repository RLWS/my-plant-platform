package com.rlws.plant.web.api.service.impl;

import com.rlws.plant.domain.User;
import com.rlws.plant.web.api.mapper.UserMapper;
import com.rlws.plant.web.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
