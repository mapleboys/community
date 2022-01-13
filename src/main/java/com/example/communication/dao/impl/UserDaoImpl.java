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
        return this.sqlSession.selectList("UserDao.queryUserAll");
    }

    @Override
    public User queryUserByToken(String token) {
        return (User)this.sqlSession.selectOne("UserDao.queryUserByToken", token);
    }

    @Override
    public User queryUserById(Integer id) {
        return (User)this.sqlSession.selectOne("UserDao.queryUserById", id);
    }

    @Override
    public List<User> queryByAccId(String accountId) {
        return this.sqlSession.selectList("UserDao.queryByAccId", accountId);
    }

    @Override
    public void updateByAccId(User user) {
        this.sqlSession.update("UserDao.updateByAccId", user);
    }

}
