package com.example.MypageService.config;

import org.springframework.cloud.openfeign.FeignBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignConfig {
    @Bean
    public FeignBuilderCustomizer feignBuilderCustomizer() {
        return builder -> builder.options(new feign.Request.Options(5000, 5000)); // 예를 들어 Feign 옵션을 설정합니다.
    }
}



