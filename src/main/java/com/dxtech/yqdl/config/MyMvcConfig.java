package com.dxtech.yqdl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig  implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/image/**").addResourceLocations("file:" + CommonConfig.uploadFilePath);
        registry.addResourceHandler("/viewimage/**").addResourceLocations("file:" + CommonConfig.uploadFilePath);
    }


    @Override
    public  void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/manage_core","/viewimage/**");
        registry.addInterceptor(new DownloadInterceptor()).addPathPatterns("/image/**");
    }

}
