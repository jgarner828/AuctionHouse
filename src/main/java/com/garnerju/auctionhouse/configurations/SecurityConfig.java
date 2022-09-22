package com.garnerju.auctionhouse.configurations;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Log4j2
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                    .csrf().ignoringAntMatchers("/ws/**", "http://localhost**")
                .and()
                    .authorizeRequests()
                    .antMatchers("/ws/**").permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .oauth2ResourceServer().jwt();

    }





}
