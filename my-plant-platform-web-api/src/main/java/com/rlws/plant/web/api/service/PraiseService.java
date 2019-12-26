package com.rlws.plant.web.api.service;

import com.rlws.plant.domain.Praise;

public interface PraiseService {
    //根据Praise查询是否存在该条数据
    Praise selectPraiseByPraise(Praise praise);

    //插入一条Praise数据
    boolean insertOnePraise(Praise praise);
}
