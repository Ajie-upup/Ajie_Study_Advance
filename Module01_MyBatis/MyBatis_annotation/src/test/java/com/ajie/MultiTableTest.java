package com.ajie;

import com.ajie.mapper.IOrderMapper;
import com.ajie.mapper.IUserMapper;
import com.ajie.pojo.Order;
import com.ajie.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: ajie
 * @Date: 2023/2/17
 * @Description:
 */
public class MultiTableTest {

    private IUserMapper userMapper;

    private IOrderMapper orderMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        userMapper = sqlSession.getMapper(IUserMapper.class);
        orderMapper = sqlSession.getMapper(IOrderMapper.class);
    }

    @Test
    public void test1() {
        List<Order> orders = orderMapper.findOrderAndUser();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void test2() {
        List<User> users = userMapper.findUserAndOrder();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test3() {
        List<User> users = userMapper.findUserAndRole();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
