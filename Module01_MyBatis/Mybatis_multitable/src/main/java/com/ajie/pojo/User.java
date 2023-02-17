package com.ajie.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ajie
 * @Date: 2023/1/27
 * @Description:
 */
@Data
public class User {
    private Integer id;
    private String username;

    //用户的订单 --- 一个用户可能拥有多个订单
    private List<Order> orderList = new ArrayList<>();

    //用户角色 ---- 一个用户可以有多个角色
    private List<Role> roleList = new ArrayList<>();

}
