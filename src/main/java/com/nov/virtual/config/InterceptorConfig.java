package com.nov.virtual.config;

import com.nov.virtual.interceptor.AdminInterceptor;
import com.nov.virtual.interceptor.AuthInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 请求拦截器
 * @author november
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private static final Logger logger =  LoggerFactory.getLogger(InterceptorConfig.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截的请求
        registry.addInterceptor(authInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api/web/login","/api/web/register");
        registry.addInterceptor(adminInterceptor()).addPathPatterns("/api/admin/**");
    }

    @Bean
    public AuthInterceptor authInterceptor(){
        return new AuthInterceptor();
    }

    @Bean
    public AdminInterceptor adminInterceptor(){
        return new AdminInterceptor();
    }

}
