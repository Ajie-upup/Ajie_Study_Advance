package com.ajie.pojo;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ajie
 * @Date: 2023/2/12
 * @Description:
 */
public class Configuration {

    private DataSource dataSource;

    /*
     *   key: statementId
     *   value：封装好的mappedStatement对象
     */
    Map<String, MappedStatement> mappedStatementMap = new HashMap<>();


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void setMappedStatementMap(Map<String, MappedStatement> mappedStatementMap) {
        this.mappedStatementMap = mappedStatementMap;
    }
}
