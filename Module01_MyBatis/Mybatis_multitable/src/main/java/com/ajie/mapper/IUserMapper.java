package com.ajie.mapper;

import com.ajie.pojo.User;

import java.util.List;

/**
 * @Author: ajie
 * @Date: 2023/1/27
 * @Description:
 */
public interface IUserMapper {

    //查询所有的用户信息，并查询出所属订单
    public List<User> findUserAndOrder();

    //多对多查询 -- 查询用户及用户的角色
    public List<User> findUserAndRole();


}
