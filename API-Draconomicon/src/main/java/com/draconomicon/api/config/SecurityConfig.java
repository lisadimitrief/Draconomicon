package com.draconomicon.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((auth) -> auth
                .requestMathchers()
                .authenticated()
        )
                .httpBasic();
        return http.build();
    }
}
