package com.example.codesystem.config;

import com.example.codesystem.Interceptor.loginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author cc
 * @date 2022年11月04日 21:44
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new loginInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/code","/user/login","/login","/css/**","/fonts/**","/images/**","/js/**");
    }
}
