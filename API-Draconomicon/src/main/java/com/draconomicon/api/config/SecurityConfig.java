package com.draconomicon.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{
    private final JwtAuthenticationFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;
	@Bean
	public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception {
        http
        .cors(withDefaults())
        .csrf((csrf) -> csrf.disable())
        .authorizeHttpRequests((auth) -> auth
        				.requestMatchers("/login").permitAll()
        				.requestMatchers("/register").permitAll()
        				.requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
        )
        .sessionManagement((auth) -> auth
        			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        		)
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
}