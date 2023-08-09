package com.wetal.bibliotheque.w_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   @Bean
   public SecurityFilterChain appSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
      return httpSecurity
         .csrf(csrf -> csrf.disable())
         .authorizeHttpRequests(auth -> {
//            auth.requestMatchers(AntPathRequestMatcher.antMatcher("/home")).permitAll();
//            auth.requestMatchers(AntPathRequestMatcher.antMatcher("/api/books/all")).permitAll();
//            auth.requestMatchers(AntPathRequestMatcher.antMatcher("/api/books/search")).permitAll();
            auth.requestMatchers("home", "/api/books/all", "/api/books/search").permitAll();
//            auth.requestMatchers("/admin").hasRole("ADMIN");
//            auth.requestMatchers("/user").hasRole("USER");
            auth.anyRequest().authenticated();
         })
         .formLogin(Customizer.withDefaults())
         .httpBasic(Customizer.withDefaults())
         .build();
   }
}
