package com.ajie;

import com.ajie.mapper.IUserMapper;
import com.ajie.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: ajie
 * @Date: 2023/2/17
 * @Description: 测试 MyBatis 缓存
 */
public class CacheTest {
    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    private IUserMapper userMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);

        userMapper = sqlSession.getMapper(IUserMapper.class);
    }

    @Test
    public void firstLevelTest() {
        //第一次查询
        User user1 = userMapper.selectById(1);
        //第二次查询
        User user2 = userMapper.selectById(1);

        System.out.println(user1 == user2);
    }

    @Test
    public void secondLevelTest() {
        //根据 sqlSessionFactory 产⽣ session
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        IUserMapper userMapper1 = sqlSession1.getMapper(IUserMapper.class);
        IUserMapper userMapper2 = sqlSession2.getMapper(IUserMapper.class);
        //第⼀次查询，发出sql语句，并将查询的结果放⼊缓存中
        User u1 = userMapper1.selectById(1);
        System.out.println(u1);
        sqlSession1.close(); //第⼀次查询完后关闭 sqlSession

        //第⼆次查询，即使sqlSession1已经关闭了，这次查询依然不发出sql语句
        User u2 = userMapper2.selectById(1);
        System.out.println(u2);
        sqlSession2.close();
        System.out.println(u1 == u2);
    }

    @Test
    public void secondLevelTest2() {
        //根据 sqlSessionFactory 产⽣ session
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        String statement = "com.ajie.pojo.IUserMapper.selectById";
        IUserMapper userMapper1 = sqlSession1.getMapper(IUserMapper.class);
        IUserMapper userMapper2 = sqlSession2.getMapper(IUserMapper.class);
        IUserMapper userMapper3 = sqlSession2.getMapper(IUserMapper.class);
        //第⼀次查询，发出sql语句，并将查询的结果放⼊缓存中
        User u1 = userMapper1.selectById(1);
        System.out.println(u1);
        sqlSession1.close(); //第⼀次查询完后关闭sqlSession

        //执⾏更新操作，commit()
        u1.setUsername("aaa");
        userMapper3.updateUser(u1);
        sqlSession3.commit();

        //第⼆次查询，由于上次更新操作，缓存数据已经清空(防⽌数据脏读)，这⾥必须再次发出sql查询
        User u2 = userMapper2.selectById(1);
        System.out.println(u2);
        sqlSession2.close();
    }

    @Test
    public void RedisCacheTest() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        IUserMapper mapper1 = sqlSession1.getMapper(IUserMapper.class);
        IUserMapper mapper2 = sqlSession2.getMapper(IUserMapper.class);
        IUserMapper mapper3 = sqlSession3.getMapper(IUserMapper.class);
        User user1 = mapper1.selectById(1);
        sqlSession1.close(); //清空⼀级缓存

        User user = new User();
        user.setId(3);
        user.setUsername("lisi");
        mapper3.updateUser(user);
        sqlSession3.commit();
        User user2 = mapper2.selectById(1);
        System.out.println(user1 == user2);
    }
}
