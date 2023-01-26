package com.ajie.dao;

import com.ajie.pojo.User;

import java.io.IOException;
import java.util.List;

/**
 * @Author: ajie
 * @Date: 2023/1/26
 * @Description:
 */
public interface IUserDao {

    public List<User> findAll() throws IOException;
}
