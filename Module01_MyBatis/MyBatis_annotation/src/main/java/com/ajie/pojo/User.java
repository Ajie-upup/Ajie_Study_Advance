package com.ajie.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ajie
 * @Date: 2023/2/17
 * @Description:
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String birthday;

    //用户的订单 --- 一个用户可能拥有多个订单
    private List<Order> orderList = new ArrayList<>();

    //用户角色 ---- 一个用户可以有多个角色
    private List<Role> roleList = new ArrayList<>();

}
