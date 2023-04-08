package dev.pmleczek.productservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http,
                                                         JwtAuthenticationManager authenticationManager,
                                                         SecurityContextRepository securityContextRepository) {
        return http
                .cors().disable()
                .csrf().disable()
                .authenticationManager(authenticationManager).securityContextRepository(securityContextRepository)
                .authorizeExchange(authz -> authz
                        .pathMatchers(HttpMethod.POST, "*").hasRole("ADMIN")
                        .pathMatchers(HttpMethod.PUT, "*").hasRole("ADMIN")
                        .pathMatchers(HttpMethod.DELETE, "*").hasRole("ADMIN")
                        .anyExchange().permitAll())
                .httpBasic().disable()
                .formLogin().disable()
                .build();
    }
}
