package com.rlws.plant.web.admin.service;

import com.rlws.plant.domain.User;

public interface UserService {

    //查询一条User信息 -->
    User selectByPrimaryKey(String email);

}
