package com.example.communication.dao;


import com.example.communication.dto.QuestionQueryByIdDto;
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
    /**
     * 根据用户id和分页查询问题
     * @param questionQueryByIdDto
     */
    public List<Question> queryQuestionByID(QuestionQueryByIdDto questionQueryByIdDto);
    /**
     * 根据用户id查询问题
     * @param creator
     */
    public List<Question> queryQuestionByCreator(Integer creator);
    /**
     * 根据问题id查询问题详情
     * @param id
     */
    public Question queryByQuestionId(Integer id);
}
