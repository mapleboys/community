package com.example.communication.dao;


import com.example.communication.model.Question;

public interface QuestionDao {

    /**
     * 新增问题
     *
     * @param question
     */
    public void insertQuestion(Question question);
}
