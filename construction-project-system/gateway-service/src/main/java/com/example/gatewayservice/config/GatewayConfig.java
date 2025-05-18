package com.example.gatewayservice.config;

import com.example.gatewayservice.filters.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

@Configuration
public class GatewayConfig {

    @Bean
    public WebFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
}