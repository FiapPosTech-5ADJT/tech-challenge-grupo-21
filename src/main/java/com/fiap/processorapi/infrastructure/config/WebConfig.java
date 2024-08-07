package com.fiap.processorapi.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Ensure this path matches where your swagger-ui-custom.html is located
        registry.addResourceHandler("/swagger-ui-custom.html**")
                .addResourceLocations("classpath:/static/");
    }
}
