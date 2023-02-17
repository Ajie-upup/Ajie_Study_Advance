package com.ajie.mapper;

import com.ajie.pojo.Order;
import com.ajie.pojo.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: ajie
 * @Date: 2023/2/17
 * @Description:
 */
public interface IOrderMapper {
    /**
     * 查询订单的同时封装订单所属的 user
     *
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "total", column = "total"),
            @Result(property = "user", column = "uid", javaType = User.class,
                    one = @One(select = "com.ajie.mapper.IUserMapper.selectById"))
    })
    @Select("select * from orders")
    public List<Order> findOrderAndUser();

    @Select("select * from orders where uid = #{id}")
    public Order findById(Integer id);

}
