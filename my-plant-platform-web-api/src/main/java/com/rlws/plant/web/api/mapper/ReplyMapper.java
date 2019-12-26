package com.rlws.plant.web.api.mapper;

import com.rlws.plant.domain.Reply;

public interface ReplyMapper {

    //插入一条Reply数据
    int insertOneReply(Reply reply);

    //根据userId查询该用户的评论数量Count
    int selectUserReplyCount(int userId);

}
