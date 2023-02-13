package com.ajie.sqlSession;

/**
 * @Author: ajie
 * @Date: 2023/2/12
 * @Description: SqlSessionFactory 接口
 */
public interface SqlSessionFactory {
    public SqlSession openSession();
}
