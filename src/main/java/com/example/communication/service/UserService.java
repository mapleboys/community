package com.example.communication.service;

import com.example.communication.mapper.QuestionMapper;
import com.example.communication.mapper.UserMapper;
import com.example.communication.model.User;
import com.example.communication.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public void insertOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);

        if (users != null && users.size() > 0) {
            // 更新用户
            user.setId(users.get(0).getId());
            userMapper.updateByExample(user, userExample);
        } else {
            // 插入用户
            userMapper.insert(user);
        }
    }
}
