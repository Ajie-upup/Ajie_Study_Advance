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

    // 多条件查询：使用where - if
    public User findByCondition(User user);

    //多值查询：使用 foreach 进行拼接
    public List<User> findByIds(int[] ids);

}
