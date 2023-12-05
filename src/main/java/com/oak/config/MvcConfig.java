package com.oak.config;

import com.oak.filter.CrossDomainFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    ImageProperties imageProperties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String prefix = imageProperties.getPrefix().endsWith("/")
                ? StringUtils.join(imageProperties.getPrefix(), "**")
                : StringUtils.join(imageProperties.getPrefix(), "/**");

        String location = imageProperties.getDirectory().endsWith("/")
                ? StringUtils.join("file:", imageProperties.getDirectory())
                : StringUtils.join("file:", imageProperties.getDirectory(), "/");

        registry.addResourceHandler(prefix)
                .addResourceLocations(location);
        /*registry.addResourceHandler("/files/**")
                // "file:" 表示指定本地文件系统
                // 注意点： 最后必须以"/" 结尾
                .addResourceLocations("file:d:/upload/et2305/");*/
    }

    @Bean
    public FilterRegistrationBean<CrossDomainFilter> crossDomainFilter() {

        FilterRegistrationBean<CrossDomainFilter> registration = new FilterRegistrationBean<>();

        // filter-class
        registration.setFilter(new CrossDomainFilter());

        // urlpattren
        registration.addUrlPatterns("/*");

        // 数值越小，越先执行
        registration.setOrder(-100);

        return registration;
    }

}