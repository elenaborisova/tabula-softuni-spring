package com.example.tabulasoftunispring.config;

import com.example.tabulasoftunispring.interceptors.StatsInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AllArgsConstructor
@Component
public class WebConfig implements WebMvcConfigurer {

    private final StatsInterceptor statsInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(statsInterceptor);
    }
}
