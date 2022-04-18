package com.c3.healthapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Maps HTML pages to paths
@Configuration
public class ViewConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/customer/dashboard").setViewName("customer/dashboard");
        registry.addViewController("/customer/").setViewName("customer/dashboard");
        registry.addViewController("/customer/weight").setViewName("customer/weight");
        registry.addViewController("/customer/heartrate").setViewName("customer/heartrate");
        registry.addViewController("/customer/respiration").setViewName("customer/respiration");
        registry.addViewController("/customer/grip").setViewName("customer/grip");
        registry.addViewController("/customer/settings").setViewName("customer/settings");
        registry.addViewController("/customer/help").setViewName("customer/help");
        registry.addViewController("/admin/dashboard").setViewName("admin/dashboard");
        registry.addViewController("/customer/uploaderror").setViewName("error/fileuploaderror");
        registry.addViewController("/error").setViewName("error/error");
    }
}
