package com.ajie.sqlSession;

import com.ajie.pojo.Configuration;


/**
 * @Author: ajie
 * @Date: 2023/2/12
 * @Description: DefaultSqlSessionFactory, 默认实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
