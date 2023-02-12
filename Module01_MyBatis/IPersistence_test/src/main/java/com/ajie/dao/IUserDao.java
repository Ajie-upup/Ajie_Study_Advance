package com.ajie.dao;

import com.ajie.pojo.User;

import java.util.List;

/**
 * @Author: ajie
 * @Date: 2023/2/12
 * @Description:
 */
public interface IUserDao {
    //查询所有用户
    public List<User> findAll() throws Exception;


    //根据条件进行用户查询
    public User findByCondition(User user) throws Exception;
}
