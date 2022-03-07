package com.txt.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/error**").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/");
    }
}

//@EnableOAuth2Sso deprecated so:
//http.oauth2Client(); //equivalent to @EnableOAuth2Client
//http.oauth2Login();  //equivalent to @EnableOAuth2Sso
