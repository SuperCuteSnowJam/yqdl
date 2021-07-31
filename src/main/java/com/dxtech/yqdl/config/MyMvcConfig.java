package com.dxtech.yqdl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig  implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        System.out.println("Hello world");
        registry.addResourceHandler("/image/**").addResourceLocations("file:C:\\yqdl-upload\\image\\" );
    }

}
