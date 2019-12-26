package com.rlws.plant.web.api.service;

import com.rlws.plant.domain.Manager;

public interface ManagerService {

    //管理员登录
    Manager managerLogin(String email);
}
