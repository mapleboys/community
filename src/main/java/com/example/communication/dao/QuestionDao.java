package com.example.communication.dao;


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
}
