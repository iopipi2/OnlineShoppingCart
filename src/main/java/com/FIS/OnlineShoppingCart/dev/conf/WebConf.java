package com.FIS.OnlineShoppingCart.dev.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Sử dụng mô hình MVC<Model, View, Controller>.
 * @author admin
 *
 */
@Configuration // -> tạo ra 1 bean tên webConf và được spring-container quản lí.
// -> đồng thời module web sẽ biết được đây là file cấu hình của web.
public class WebConf implements WebMvcConfigurer {

    // cấu hình cho MVC biết chỗ folder để lấy view trả về cho Browser.
    @Bean public ViewResolver viewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/"); // thư mục gốc chứa các file jsp.
        bean.setSuffix(".jsp");
        return bean;
    }
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        // Load file: validation.properties
        messageSource.setBasename("classpath:validation");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /**
     * Hàm này sẽ báo cho module web biết nơi để View(Jsp) biết load static resources(css, js)
     * classpath: <-> src/main/resources
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/META-INF/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/META-INF/js/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/META-INF/images/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/META-INF/fonts/");
        registry.addResourceHandler("/vendor/**").addResourceLocations("classpath:/META-INF/vendor/");
        registry.addResourceHandler("/summernote/**").addResourceLocations("classpath:/META-INF/summernote/");

        registry.addResourceHandler("file/upload/**").addResourceLocations("file:C:\\Users\\PV\\OneDrive\\Máy tính\\DoAnTotNghiepHaUI\\upload\\");
    }
}
