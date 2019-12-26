package com.rlws.plant.web.api.service.impl;

import com.rlws.plant.domain.Answer;
import com.rlws.plant.web.api.mapper.AnswerMapper;
import com.rlws.plant.web.api.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    //用户回答问题
    @Override
    public boolean userAnswerQuestion(Answer answer) {
        int i = answerMapper.insertOneAnswer(answer);
        return i > 0 ? true : false;
    }

    //判断用户是否回答过该问题
    @Override
    public Answer selectUserAnswerQuestion(Answer answer) {
        Answer answer1 = answerMapper.selectUserAnswerQuestion(answer);
        return answer1;
    }

    //获取某个问题下的所有回答
    @Override
    public List<Answer> getAllAnswerByQuestionId(int id) {
        List<Answer> answers = answerMapper.selectListAnswerByQuestionId(id);
        return answers;
    }

    //用户举报一个回答
    @Override
    public Answer userReportAnswer(int id) {
        Answer answer = answerMapper.selectAnswerById(id);
        return answer;
    }

    //获取一个最佳回答
    @Override
    public Answer selectOptimalAnswerById(int answerId) {
        Answer answer = answerMapper.selectOptimalAnswerById(answerId);
        return answer;
    }

    //用户点赞答案
    @Override
    public boolean userClickOneAnswer(int answerId) {
        Answer answer = answerMapper.selectAnswerById(answerId);
        answer.setPraise(answer.getPraise() + 1);
        int i = answerMapper.updateOneAnswer(answer);
        return i > 0 ? true : false;
    }

    //删除一条Answer数据
    @Override
    public boolean deleteOneAnswer(int answerId) {
        int i = answerMapper.deleteOneAnswer(answerId);
        return i > 0 ? true : false;
    }
}
