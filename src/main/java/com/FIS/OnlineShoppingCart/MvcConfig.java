package com.FIS.OnlineShoppingCart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        Path productUploadDir = Paths.get("./product-images");
        Path blogUploadDir = Paths.get("./blog-images");
        Path avatarUploadDir = Paths.get("./avatar-images");

        String productUploadPath = productUploadDir.toFile().getAbsolutePath();
        String blogUploadPath = blogUploadDir.toFile().getAbsolutePath();
        String avatarUploadPath = avatarUploadDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/product-images/**").addResourceLocations("file:/" + productUploadPath + "/");
        registry.addResourceHandler("/blog-images/**").addResourceLocations("file:/" + blogUploadPath + "/");
        registry.addResourceHandler("/avatar-images/**").addResourceLocations("file:/" + avatarUploadPath + "/");




    }



}