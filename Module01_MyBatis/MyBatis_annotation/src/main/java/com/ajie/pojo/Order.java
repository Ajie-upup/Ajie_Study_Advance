package com.ajie.pojo;

import lombok.Data;

/**
 * @Author: ajie
 * @Date: 2023/2/17
 * @Description:
 */
@Data
public class Order {
    private Integer id;
    private String orderTime;
    private Double total;
    //该订单所属的用户
    private User user;
}
