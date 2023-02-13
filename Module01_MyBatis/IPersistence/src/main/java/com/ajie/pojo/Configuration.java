package com.ajie.pojo;

import lombok.Data;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ajie
 * @Date: 2023/2/12
 * @Description: Configuration 存放数据源信息，保存 sql 语句
 */
@Data
public class Configuration {

    private DataSource dataSource;

    /*
     *   key: statementId
     *   value：封装好的mappedStatement对象
     */
    Map<String, MappedStatement> mappedStatementMap = new HashMap<>();
}
