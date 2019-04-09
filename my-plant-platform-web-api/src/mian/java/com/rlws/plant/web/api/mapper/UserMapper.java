package com.rlws.plant.web.api.mapper;

import com.rlws.plant.domain.User;

public interface UserMapper {

    //根据id主键来对用户表进行查询
    User selectByPrimaryKey(String email);

}
