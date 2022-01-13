package com.example.communication.service;

import com.example.communication.dao.UserDao;
import com.example.communication.model.User;
import com.example.communication.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public static void insertOrUpdate(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlseesion();
        UserDao userdao = sqlSession.getMapper(UserDao.class);
        List<User> users = userdao.queryByAccId(user.getAccountId());
        if (users != null && users.get(0) != null) {
            // 更新用户
            userdao.updateByAccId(user);
            sqlSession.commit();
        } else {
            // 插入用户
            userdao.insertUser(user);
            sqlSession.commit();
        }


    }
}
