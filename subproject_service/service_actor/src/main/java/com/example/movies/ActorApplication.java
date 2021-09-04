package com.example.movies;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 主配置类.
 *
 * @Author: 许昊天
 * @Date: 2021/09/02/15:51
 * @Description:
 */
@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@MapperScan("com.example.movies.mapper")
public class ActorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActorApplication.class, args);
    }
}
