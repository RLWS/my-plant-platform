package com.rlws.plant.web.api.mapper;

import com.rlws.plant.domain.Message;

import java.util.List;

public interface MessageMapper {

    //插入一条Message数据
    int insertOneMessage(Message message);

    //根据用户的Id获取所有Message
    List<Message> getUserAllMessage(Message message);
}
