package com.rlws.plant.web.api.service.impl;

import com.rlws.plant.domain.Apply;
import com.rlws.plant.domain.PageVo;
import com.rlws.plant.web.api.mapper.ApplyMapper;
import com.rlws.plant.web.api.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyMapper applyMapper;

    //插入一条Apply数据
    @Override
    public boolean insertOneApply(Apply apply) {
        int i = applyMapper.insertOneApply(apply);
        return i > 0 ? true : false;
    }

    @Override
    public Apply selectOneApply(int applyId) {
        Apply apply = applyMapper.selectOneApply(applyId);
        return apply;
    }

    //获取所有的数据
    @Override
    public List<Apply> selectAllApply(PageVo pageVo) {
        List<Apply> applies = applyMapper.selectAllApply(pageVo);
        return applies;
    }

    //获取所有的数据数量Count
    @Override
    public int selectAllApplyCount() {
        return applyMapper.selectAllApplyCount();
    }

    //删除一条Apply数据
    @Override
    public boolean deleteOneApply(int applyId) {
        int i = applyMapper.deleteOneApply(applyId);
        return i > 0 ? true : false;
    }

    @Override
    public boolean updateOneApply(Apply apply) {
        int i = applyMapper.updateOneApply(apply);
        return i > 0 ? true : false;
    }
}
