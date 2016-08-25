/*
 * UserMapper.java
 * Copyright(C) 2012-2016 Liz Company
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-25 Created
 */
package com.liz.incubator.mapper;

import com.liz.incubator.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}