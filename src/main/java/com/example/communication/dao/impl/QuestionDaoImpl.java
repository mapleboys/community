package com.example.communication.dao.impl;

import com.example.communication.dao.QuestionDao;
import com.example.communication.dto.QuestionQueryByIdDto;
import com.example.communication.dto.QuestionQueryDto;
import com.example.communication.model.Question;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class QuestionDaoImpl implements QuestionDao {
    public SqlSession sqlSession;

    public QuestionDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void insertQuestion(Question question) {
        this.sqlSession.insert("QuestionDao.insertQuestion", question);
    }

    @Override
    public List<Question> queryQuestionAll() {
        return this.sqlSession.selectList("QuestionDao.queryQuestionAll");
    }

    @Override
    public List<Question> queryQuestionByPage(QuestionQueryDto questionQueryDto) {
        return this.sqlSession.selectList("QuestionDao.queryQuestionByPage", questionQueryDto);
    }

    @Override
    public List<Question> queryQuestionByID(QuestionQueryByIdDto questionQueryByIdDto) {
        return this.sqlSession.selectList("QuestionDao.queryQuestionByID", questionQueryByIdDto);
    }

    @Override
    public List<Question> queryQuestionByCreator(Integer creator) {
        return this.sqlSession.selectList("QuestionDao.queryQuestionByCreator", creator);
    }

    @Override
    public Question queryByQuestionId(Integer id) {
        return (Question) this.sqlSession.selectOne("QuestionDao.queryByQuestionId", id);
    }


}
