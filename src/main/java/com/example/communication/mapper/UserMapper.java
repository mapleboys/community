package com.example.communication.mapper;

import com.example.communication.model.User;
import org.apache.ibatis.annotations.Insert;
import org.mybatis.spring.annotation.MapperScan;

public interface UserMapper {
    @Insert("insert into user(name, account_id, token, gmt_create, gmt_modified)values(" +
            "#{name}, #{accountId}, #{token}, #{gmtCreate}, #{gmtModified})")
    void insert(User user);
}
