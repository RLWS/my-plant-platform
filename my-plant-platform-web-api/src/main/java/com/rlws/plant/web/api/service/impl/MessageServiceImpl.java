package com.rlws.plant.web.api.service.impl;

import com.rlws.plant.domain.Message;
import com.rlws.plant.web.api.mapper.MessageMapper;
import com.rlws.plant.web.api.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    //插入一条Message数据
    @Override
    public boolean insertOneMessage(Message message) {
        int i = messageMapper.insertOneMessage(message);
        return i > 0 ? true : false;
    }

    //根据用户的Id获取所有Message
    @Override
    public List<Message> getUserAllMessage(Message message) {
        List<Message> userAllMessage = messageMapper.getUserAllMessage(message);
        return userAllMessage;
    }
}
