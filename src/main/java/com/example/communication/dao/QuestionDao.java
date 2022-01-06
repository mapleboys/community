package com.example.communication.dao;


import com.example.communication.dto.QuestionQueryDto;
import com.example.communication.model.Question;

import java.util.List;

public interface QuestionDao {

    /**
     * 新增问题
     *
     * @param question
     */
    public void insertQuestion(Question question);

    /**
     * 查询所有问题
     *
     * @param
     * @return
     */
    public List<Question> queryQuestionAll();
    /**
     * 根据rows和offset查询问题
     * @param questionQueryDto
     */
    public List<Question> queryQuestionByPage(QuestionQueryDto questionQueryDto);
}
