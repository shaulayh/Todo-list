package com.shaulayh.config;

import com.shaulayh.utils.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Slf4j
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.shaulayh")
public class WebConfig implements WebMvcConfigurer {

    private static final String RESOLVE_PREFIX = "/WEB-INF/view/";
    private static final String RESOLVE_SUFFIX = ".jsp";

    @Bean
    public ViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(RESOLVE_PREFIX);
        viewResolver.setSuffix(RESOLVE_SUFFIX);
        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("home").setViewName(ViewNames.HOME);
    }
}
