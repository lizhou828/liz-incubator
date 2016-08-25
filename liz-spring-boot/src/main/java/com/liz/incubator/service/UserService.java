package com.liz.incubator.service;

import com.liz.incubator.model.User;
import com.liz.common.utils.Md5Util;
import com.liz.common.utils.StringUtil;
import com.liz.incubator.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lizhou on 2016/6/14
 */

@Transactional(rollbackFor = Exception.class)
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User login(User user) {
        if(null == user) return null;
        if(StringUtil.isEmpty(user.getUserName()) || StringUtil.isEmpty(user.getPassword())) {
            return null;
        }
        User userNew = new User();
        userNew.setUserName(user.getUserName());
        userNew.setPassword(Md5Util.encrypt(user.getPassword()));
//        return userMapper.findByUser(userNew);
        return null;
    }

    public void logout(User user) {

    }

    public void register(User user) {

    }

//    public List<User> list() {
//        return userMapper.list();
//    }

    public User getByPK(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public void save(User user) {
        userMapper.insert(user);
    }

    public void delete(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    public void update(User user) {
        //在当前类上加上：@Transactional(rollbackFor = Exception.class) 注解后，测试是否能控制事务
        //userMapper.update(user);
        //int i = 1/0;
        userMapper.updateByPrimaryKeySelective(user);
    }

//    public User findByUser(User user) {
//        return userMapper.findByUser(user);
//    }
}
