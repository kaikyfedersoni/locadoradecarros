package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/aluguel","/api/aluguel/listar","/api/aluguel/excluir/**","/api/aluguel/editar/**","/api/aluguel/alugar").permitAll()
            .requestMatchers("/api/auth","/api/auth/listar","/api/auth/excluir/**","/api/auth/editar/**","/api/auth/registrar").permitAll()
            .requestMatchers("/api/carro","/api/carro/listar","/api/carro/excluir/**","/api/carro/editar/**","/api/carro/adicionar").permitAll()
            .anyRequest().authenticated() 
        )
        .httpBasic(); 
    return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

