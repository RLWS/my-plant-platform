package com.rlws.plant.web.api.service;

import com.rlws.plant.domain.Reply;

public interface ReplyService {

    //用户评论回答
    boolean userReplyAnswer(Reply reply);

    //根据userId查询该用户的评论数量Count
    int selectUserReplyCount(int userId);

}
