package com.request.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class HttpRequestConfiguration {

    @Bean
    public FilterRegistrationBean<HttpRequestCustomFilter> loggingFilter() {
        FilterRegistrationBean<HttpRequestCustomFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new HttpRequestCustomFilter());
        bean.addUrlPatterns("/demo/*");
        return bean;
    }
}
