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

    /**
     * 查询用户
     *
     */
    public List<User> queryUserAll();

    /**
     * 根据token查询用户
     *
     */
    public User queryUserByToken(String token);

    /**
     * 根据id查询用户
     *
     */
    public User queryUserById(Integer id);
    /**
     * 根据AccountId查询用户
     *
     */
    public List<User> queryByAccId(String accountId);
    /**
     * 根据AccountId更新用户信息
     *
     */
    public void updateByAccId(User user);
}
