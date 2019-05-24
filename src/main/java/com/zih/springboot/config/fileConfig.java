package com.zih.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

//外部资源映射配置类，访问项目路径及资源在磁盘的路径
@Configuration
public class fileConfig implements WebMvcConfigurer {
    @Autowired
    private testInterceptors testInterceptor;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:D://img/");
    }
    //hello
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor).addPathPatterns("/user/insertUser");
    }
}