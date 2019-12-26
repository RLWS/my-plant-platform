package com.rlws.plant.web.api.service;

import com.rlws.plant.domain.PageVo;
import com.rlws.plant.domain.Report;

import java.util.List;

public interface ReportService {

    //用户举报
    boolean insertOneReport(Report report);

    //删除一条Report信息
    boolean deleteOneReport(int reportId);

    //查询出所有的Report信息(Question)
    List<Report> selectAllReportQuestion(PageVo pageVo);

    //查询出所有的Report信息(Question)的数量Count
    int selectAllReportQuestionCount();

    //查询出所有的Report信息(Answer)
    List<Report> selectAllReportAnswer(PageVo pageVo);

    //查询出所有的Report信息(Answer)的数量Count
    int selectAllReportAnswerCount();

}
