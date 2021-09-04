package com.example.movies.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 配置类.
 *
 * @Author: 许昊天
 * @Date: 2021/09/02/14:59
 * @Description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 构建api文档的详细信息函数
     * @return
     */
    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("Api文档")
                // 描述
                .description("描述微服务接口定义")
                // 版本号
                .version("1.0")
                // 创建人
                .contact(new Contact("java", "http://zmxdata.com", "hksupports@163.com"))
                .build();
    }

    /**
     * 构建接口文档
     * @return
     */
    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 分组名
                .groupName("webApi")
                // 设置描述文件
                .apiInfo(webApiInfo())
                // 用来等待文件描述词状态的改变
                .select()
                // 只显示api路径下的页面
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

}
