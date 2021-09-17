package com.example.movies.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 工具类 启动时自动读取.
 *
 * @Author: 许昊天
 * @Date: 2021/09/15/11:11
 * @Description:
 */
@Component
public class ConstantPropertiesUtils implements InitializingBean {
    /**
     * 读取配置文件application.properties
     * oss的地址、id、密钥、Bucket名称
     */
    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.file.keyid}")
    private String keyId;
    @Value("${aliyun.oss.file.keysecret}")
    private String keySecret;
    @Value("${aliyun.oss.file.bucketname}")
    private String buckerName;

    /**
     * 创建常量
     */
    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        ACCESS_KEY_ID = keyId;
        ACCESS_KEY_SECRET = keySecret;
        BUCKET_NAME = buckerName;
    }
}
