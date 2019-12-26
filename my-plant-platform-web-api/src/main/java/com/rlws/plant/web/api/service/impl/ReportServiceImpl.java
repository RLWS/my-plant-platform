package com.rlws.plant.web.api.service.impl;

import com.rlws.plant.domain.PageVo;
import com.rlws.plant.domain.Report;
import com.rlws.plant.web.api.mapper.ReportMapper;
import com.rlws.plant.web.api.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public boolean insertOneReport(Report report) {
        int i = reportMapper.insertOneReport(report);
        return i > 0 ? true : false;
    }

    //删除一条Report信息
    @Override
    public boolean deleteOneReport(int reportId) {
        int i = reportMapper.deleteOneReport(reportId);
        return i > 0 ? true : false;
    }

    //查询出所有的Report信息(Question)
    @Override
    public List<Report> selectAllReportQuestion(PageVo pageVo) {
        List<Report> reports = reportMapper.selectAllReportQuestion(pageVo);
        return reports;
    }

    //查询出所有的Report信息(Question)的数量Count
    @Override
    public int selectAllReportQuestionCount() {
        int i = reportMapper.selectAllReportQuestionCount();
        return i;
    }

    //查询出所有的Report信息(Answer)
    @Override
    public List<Report> selectAllReportAnswer(PageVo pageVo) {
        List<Report> reports = reportMapper.selectAllReportAnswer(pageVo);
        return reports;
    }

    //查询出所有的Report信息(Answer)的数量Count
    @Override
    public int selectAllReportAnswerCount() {
        int i = reportMapper.selectAllReportAnswerCount();
        return i;
    }
}
