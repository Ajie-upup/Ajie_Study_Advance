package com.ajie.mapper;

import com.ajie.pojo.Order;

import java.util.List;

/**
 * @Author: ajie
 * @Date: 2023/1/27
 * @Description:
 */
public interface IOrderMapper {

    public List<Order> findOrderAndUser();
}
