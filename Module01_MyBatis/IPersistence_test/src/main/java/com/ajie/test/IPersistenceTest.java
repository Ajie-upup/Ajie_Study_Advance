package com.ajie.test;

import com.ajie.dao.IUserDao;
import com.ajie.io.Resources;
import com.ajie.pojo.User;
import com.ajie.sqlSession.SqlSession;
import com.ajie.sqlSession.SqlSessionFactory;
import com.ajie.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @Author: ajie
 * @Date: 2023/2/11
 * @Description:
 */
public class IPersistenceTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
//        /*User user2 = sqlSession.selectOne("user.selectOne", user);
//
//        System.out.println(user2);*/
//
//       /* List<User> users = sqlSession.selectList("user.selectList");
//        for (User user1 : users) {
//            System.out.println(user1);
//        }*/
//
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        User res = userDao.findByCondition(user);
        System.out.println(res);
//        List<User> all = userDao.findAll();
//        for (User user1 : all) {
//            System.out.println(user1);
//        }
    }
}
