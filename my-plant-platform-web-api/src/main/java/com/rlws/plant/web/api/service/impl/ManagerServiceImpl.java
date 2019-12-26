package com.rlws.plant.web.api.service.impl;

import com.rlws.plant.domain.Manager;
import com.rlws.plant.web.api.mapper.ManagerMapper;
import com.rlws.plant.web.api.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public Manager managerLogin(String email) {
        Manager manager = managerMapper.selectManagerById(email);
        return manager;
    }
}
