package com.ajie.test;

import com.ajie.dao.IUserDao;
import com.ajie.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: ajie
 * @Date: 2023/1/25
 * @Description:
 */
public class MyTest {

    @Test
    public void selectAll() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        //获取sqlSession 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获取 sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行 sql 语句
        List<User> users = sqlSession.selectList("userMapper.findAll");

        for (User user : users) {
            System.out.println(user);
        }

        //关闭资源
        sqlSession.close();
    }

    @Test
    public void insert() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        //获取sqlSession 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获取 sqlSession 对象 ----开启自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        User user = new User();
        user.setId(4);
        user.setUsername("赵六");
        //执行 sql 语句
        sqlSession.insert("userMapper.insert", user);

        //关闭资源
        sqlSession.close();
    }

    @Test
    public void update() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        //获取sqlSession 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获取 sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        //执行 sql 语句
        sqlSession.insert("userMapper.updateById", user);

        sqlSession.commit();

        //关闭资源
        sqlSession.close();
    }

    @Test
    public void delete() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        //获取sqlSession 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获取 sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int id = 4;
        //执行 sql 语句
        sqlSession.insert("userMapper.deleteById", id);

        sqlSession.commit();

        //关闭资源
        sqlSession.close();
    }

    @Test
    public void daoTest() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlSession 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取 sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //关闭资源
        sqlSession.close();
    }

    @Test
    public void findByCondition() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlSession 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取 sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setUsername("李四");
        User userCollect = userDao.findByCondition(user);
        System.out.println(userCollect);

        //关闭资源
        sqlSession.close();
    }

    @Test
    public void findByIds() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlSession 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取 sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        int[] ids = {1, 2};
        List<User> users = userDao.findByIds(ids);
        for (User user : users) {
            System.out.println(user);
        }
        //关闭资源
        sqlSession.close();
    }

}
