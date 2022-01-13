package com.example.communication.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

//@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    SessionInterceptor sessionInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        ArrayList<String> strList = new ArrayList<>();
//        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**").excludePathPatterns("index", "/static/**");
//        System.out.println("before" + LocalDateTime.now());
//        SessionInterceptor interceptor = new SessionInterceptor();
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/publish");
    }


//    /**
//     * 这个方法是用来配置静态资源的，比如html，js，css，等等
//     *
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("/static/**");
//    }
}
