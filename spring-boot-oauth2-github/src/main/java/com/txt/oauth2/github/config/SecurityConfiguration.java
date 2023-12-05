package com.txt.oauth2.github.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/login", "/error").permitAll()
                .anyRequest()
                .authenticated());

        http.oauth2Login(httpSecurityOAuth2LoginConfigurer -> httpSecurityOAuth2LoginConfigurer.loginPage("/login"));
        http.formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.permitAll().loginPage("/login"));
        http.logout(httpSecurityLogoutConfigurer -> {
            httpSecurityLogoutConfigurer.logoutUrl("/logout");
            httpSecurityLogoutConfigurer.logoutSuccessUrl("/login?logout");
            httpSecurityLogoutConfigurer.deleteCookies("true");
        });

//        http.oauth2Login(Customizer.withDefaults());
//        http.formLogin(Customizer.withDefaults());
//        http.logout(Customizer.withDefaults());

        return http.build();
    }

}
