package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .authorizeHttpRequests(auth -> auth
        .requestMatchers("/api/carro/adicionar","/api/carro/editar/**","/api/carro/excluir/**").hasRole("ADMIN") 
        .requestMatchers("/api/aluguel/listar","/api/aluguel/excluir/**","/api/auth/listar","/api/auth/listar/role/**").hasRole("ADMIN")
        .requestMatchers("/api/aluguel/alugar").hasRole("CLIENTE")
        .anyRequest().permitAll()
        )
        .httpBasic(); 
    return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}