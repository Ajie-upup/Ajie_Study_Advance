package com.ajie.sqlSession;

import com.ajie.pojo.Configuration;
import com.ajie.pojo.MappedStatement;

import java.util.List;

/**
 * @Author: ajie
 * @Date: 2023/2/12
 * @Description:
 */
public interface Executor {
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;
}
