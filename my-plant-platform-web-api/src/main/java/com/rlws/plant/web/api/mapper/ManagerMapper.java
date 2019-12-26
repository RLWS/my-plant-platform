package com.rlws.plant.web.api.mapper;

import com.rlws.plant.domain.Manager;

public interface ManagerMapper {

    //查询一条Manager信息
    Manager selectManagerById(String email);
}
