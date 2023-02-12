package com.ajie.io;

import java.io.InputStream;

/**
 * @Author: ajie
 * @Date: 2023/2/11
 * @Description: Resources 提供获取配置文件的流的方法
 */
public class Resources {

    // 根据配置文件的路径，将配置文件加载成字节输入流，存储在内存中
    public static InputStream getResourceAsSteam(String path) {
        InputStream resourceAsStream = Resources.class.getClassLoader().getResourceAsStream(path);
        return resourceAsStream;
    }
}
