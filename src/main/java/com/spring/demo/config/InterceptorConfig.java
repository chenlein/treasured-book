package com.spring.demo.config;

import com.spring.demo.interceptor.CustomizeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName InterceptorConfig
 * @Author leichen.china@gmail.com
 * @Date 2019-08-21 16:56
 * @Describe TODO
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomizeInterceptor());
    }
}
