package com.garnerju.auctionhouse.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtException;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public JwtDecoder jwtDecoder() {
        return new JwtDecoder() {
            @Override
            public Jwt decode(String token) throws JwtException {
                return null;
            }
        };
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                    .csrf().ignoringAntMatchers("/ws/**")
                .and()
                    .authorizeRequests()
                    .antMatchers("/ws/**").permitAll()
                    .antMatchers(HttpMethod.GET, "/auctionlist")
                    .hasAuthority("SCOPE_read")
                    .antMatchers(HttpMethod.POST, "/auctionitems/*")
                    .hasAuthority("SCOPE_write")
                    .anyRequest()
                    .authenticated()
                    .and()
                    .oauth2ResourceServer()
                .jwt()
                .decoder(new JwtDecoder() {
                    @Override
                    public Jwt decode(String token) throws JwtException {
                        return null;
                    }
                });

    }





}
