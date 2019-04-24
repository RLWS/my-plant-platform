package com.rlws.plant.web.api.service;

import com.rlws.plant.domain.User;

public interface UserService {

    //查询一条User信息 -->
    User selectByPrimaryKey(String email);

}
