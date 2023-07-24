package com.draconomicon.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder().encode("USER"))
            .roles("USER")
            .build();
        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("ADMIN"))
            .roles("ADMIN")
            .build();
    
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth ->auth.anyRequest().permitAll())
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    
    

    //////Sécurité basique//////////////////
    // public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception{
    //     http.authorizeHttpRequests((auth) -> auth
    //             .requestMatchers("/role").hasRole("ADMIN")
    //             .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
    //             // .requestMatchers("/encyclopedie").permitAll() //il enleve l'authentification
                
    //             .anyRequest()
    //             .authenticated()
            
    //     )
    //             .httpBasic();
    //     return http.build();
    // }



}
