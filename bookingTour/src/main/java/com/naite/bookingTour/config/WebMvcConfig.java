package com.naite.bookingTour.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {///login controller handle by this
//        registry.addViewController("/login").setViewName("pages/auth_login.html");//login controller, and user will redirect to this page auth_login.html
//    }
}