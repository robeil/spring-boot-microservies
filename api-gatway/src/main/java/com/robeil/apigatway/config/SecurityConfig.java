package com.robeil.apigatway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final String[] freeResourceUrls = {"/swagger-ui.html","/swagger-ui/**","/v3/api-docs/**","/swagger-resources/**","/api-docs/**","/aggregate/**"};
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(freeResourceUrls).permitAll()
                        .anyRequest()
                .authenticated())
                .oauth2ResourceServer((aouht2 -> aouht2.jwt(Customizer.withDefaults())))
                .build();

    }
}
