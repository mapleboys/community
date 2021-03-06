package com.example.communication.mapper;

import com.example.communication.model.User;
import com.example.communication.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bbs_users
     *
     * @mbg.generated Tue Jan 25 17:32:47 CST 2022
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bbs_users
     *
     * @mbg.generated Tue Jan 25 17:32:47 CST 2022
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bbs_users
     *
     * @mbg.generated Tue Jan 25 17:32:47 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bbs_users
     *
     * @mbg.generated Tue Jan 25 17:32:47 CST 2022
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bbs_users
     *
     * @mbg.generated Tue Jan 25 17:32:47 CST 2022
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bbs_users
     *
     * @mbg.generated Tue Jan 25 17:32:47 CST 2022
     */
    List<User> selectByExampleWithRowbounds(UserExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bbs_users
     *
     * @mbg.generated Tue Jan 25 17:32:47 CST 2022
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bbs_users
     *
     * @mbg.generated Tue Jan 25 17:32:47 CST 2022
     */
    User selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bbs_users
     *
     * @mbg.generated Tue Jan 25 17:32:47 CST 2022
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bbs_users
     *
     * @mbg.generated Tue Jan 25 17:32:47 CST 2022
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bbs_users
     *
     * @mbg.generated Tue Jan 25 17:32:47 CST 2022
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bbs_users
     *
     * @mbg.generated Tue Jan 25 17:32:47 CST 2022
     */
    int updateByPrimaryKey(User record);
}