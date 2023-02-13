package com.ajie.pojo;

import lombok.Data;

/**
 * @Author: ajie
 * @Date: 2023/2/12
 * @Description: MappedStatement 保存 mapper 中的信息
 */
@Data
public class MappedStatement {
    //id标识
    private String id;
    //返回值类型
    private String resultType;
    //参数值类型
    private String paramterType;
    //sql语句
    private String sql;

}
