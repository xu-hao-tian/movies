package com.example.movies.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * 跨域配置类.
 *
 * @Author: 许昊天
 * @Date: 2021/09/16/15:18
 * @Description:
 */
@Configuration
public class MyCorsConfiguration {
    @Bean
    public CorsWebFilter corsWebFilter() {
        // 获取跨域配置信息的容器
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 具体封装跨域配置信息的pojo
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 跨域配置
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.setAllowCredentials(true);
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(source);
    }
}
