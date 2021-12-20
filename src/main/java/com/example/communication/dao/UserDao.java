package com.example.communication.dao;

import com.example.communication.model.User;
import java.util.List;

public interface UserDao {

    /**
     * 新增用户
     *
     * @param user
     */
    public void insertUser(User user);

}
