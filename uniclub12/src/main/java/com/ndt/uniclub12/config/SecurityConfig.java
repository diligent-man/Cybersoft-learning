package com.ndt.uniclub12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;


@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configSecurityFilterChain(HttpSecurity http) {
        return http
            .csrf(CsrfConfigurer::disable)
            .sessionManagement(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(
                rq -> {
                    rq.requestMatchers(HttpMethod.GET, "/product").permitAll();
                    rq.requestMatchers(HttpMethod.POST, "/product").hasRole("ADMIN");
                    rq.requestMatchers(HttpMethod.PUT, "/auth/*").permitAll();

                    // tất cả các request còn lại đều phải chứng thực
                    rq.anyRequest().authenticated();
                }
            )
            .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
