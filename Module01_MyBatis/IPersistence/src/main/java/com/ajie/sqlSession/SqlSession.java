package com.ajie.sqlSession;

import java.util.List;

/**
 * @Author: ajie
 * @Date: 2023/2/12
 * @Description: SqlSession 接口
 */
public interface SqlSession {

    //查询所有
    public <E> List<E> selectList(String statementId, Object... params) throws Exception;

    //根据条件查询单个
    public <T> T selectOne(String statementId, Object... params) throws Exception;


    //为Dao接口生成代理实现类
    public <T> T getMapper(Class<?> mapperClass);

}
