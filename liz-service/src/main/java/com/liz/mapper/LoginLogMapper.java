package com.liz.mapper;

import com.liz.model.LoginLog;

public interface LoginLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbggenerated
     */
    int insert(LoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbggenerated
     */
    int insertSelective(LoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbggenerated
     */
    LoginLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(LoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(LoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LoginLog record);
}