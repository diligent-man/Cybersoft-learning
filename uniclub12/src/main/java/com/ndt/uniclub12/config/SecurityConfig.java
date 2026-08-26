package com.ndt.uniclub12.config;

import com.ndt.uniclub12.filter.AuthenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;


@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configSecurityFilterChain(
        HttpSecurity http,
        AuthenFilter authenFilter
    ) {
        return http
            .csrf(CsrfConfigurer::disable)
            .cors(CorsConfigurer::disable)
            .sessionManagement(AbstractHttpConfigurer::disable)
            .addFilterBefore(authenFilter, UsernamePasswordAuthenticationFilter.class)
            .authorizeHttpRequests(
                rq -> {
                    rq.requestMatchers(
                        "/api/jwt/*",
                        "/files", "/files/*"
                    ).permitAll();

                    rq.requestMatchers(HttpMethod.GET, "/product").permitAll();

                    rq.requestMatchers(HttpMethod.POST, "/product").hasRole("ADMIN");
                    rq.requestMatchers(HttpMethod.POST, "/auth/*").permitAll();

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


    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(List.of("http://127.0.0.1:5500"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(false); // Only if you're using cookies/session auth

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
