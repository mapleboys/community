package com.example.communication.dao.impl;

import com.example.communication.dao.QuestionDao;
import com.example.communication.model.Question;
import org.apache.ibatis.session.SqlSession;

public class QuestionDaoImpl implements QuestionDao {
    public SqlSession sqlSession;

    public QuestionDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void insertQuestion(Question question) {
        this.sqlSession.insert("QuestionDao.insertQuestion", question);
    }
}
