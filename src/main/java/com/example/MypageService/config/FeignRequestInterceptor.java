package com.example.MypageService.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;

public class FeignRequestInterceptor implements RequestInterceptor {

    private final CircuitBreaker circuitBreaker;
    private final TimeLimiter timeLimiter;

    public FeignRequestInterceptor(CircuitBreakerRegistry circuitBreakerRegistry, TimeLimiterRegistry timeLimiterRegistry) {
        this.circuitBreaker = circuitBreakerRegistry.circuitBreaker("easyResponseCircuitBreaker");
        this.timeLimiter = timeLimiterRegistry.timeLimiter("easyResponseTimeLimiter");
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("CircuitBreaker", circuitBreaker.getName());
        template.header("TimeLimiter", timeLimiter.getName());
    }
}

