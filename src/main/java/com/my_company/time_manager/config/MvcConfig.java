package com.my_company.time_manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("show_users");
        registry.addViewController("/login").setViewName("admin_login");
        registry.addViewController("/registration").setViewName("admin_reg");
    }
}
