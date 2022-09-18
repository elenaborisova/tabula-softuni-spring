package com.example.tabulasoftunispring.interceptors;

import com.example.tabulasoftunispring.services.StatsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
@Component
public class StatsInterceptor implements HandlerInterceptor {

    private final StatsService statsService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        statsService.incRequestCount();
        return true;
    }
}
