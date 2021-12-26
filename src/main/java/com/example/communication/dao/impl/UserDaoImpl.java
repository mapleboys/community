package com.example.communication.dao.impl;

import com.example.communication.dao.UserDao;
import com.example.communication.model.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {
    public SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void insertUser(User user) {
        this.sqlSession.insert("UserDao.insertUser", user);
    }

    @Override
    public List<User> queryUserAll() {
        return this.sqlSession.selectList("UserDao.selectUser");
    }

}
