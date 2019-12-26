package com.rlws.plant.web.api.service.impl;

import com.rlws.plant.domain.Reply;
import com.rlws.plant.web.api.mapper.ReplyMapper;
import com.rlws.plant.web.api.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    //用户评论回答
    @Override
    public boolean userReplyAnswer(Reply reply) {
        int i = replyMapper.insertOneReply(reply);
        return i > 0 ? true : false;
    }

    //根据userId查询该用户的评论数量Count
    @Override
    public int selectUserReplyCount(int userId) {
        int i = replyMapper.selectUserReplyCount(userId);
        return i;
    }
}
