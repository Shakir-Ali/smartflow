package com.smartflow.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
public class AuditorConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                return Optional.empty();
            }
            return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        };
    }
}
