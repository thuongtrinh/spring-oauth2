package com.txt.oauth2.login.config;

import com.txt.oauth2.login.config.oauth.CustomOAuth2UserService;
import com.txt.oauth2.login.config.oauth.OAuthLoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private CustomOAuth2UserService oauth2UserService;

    @Autowired
    private OAuthLoginSuccessHandler oauthLoginSuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/login", "/error").permitAll()
                .anyRequest()
                .authenticated());

        http.oauth2Login(httpSecurityOAuth2LoginConfigurer -> {
            httpSecurityOAuth2LoginConfigurer.loginPage("/login");
            httpSecurityOAuth2LoginConfigurer.userInfoEndpoint(ue -> ue.userService(oauth2UserService));
            httpSecurityOAuth2LoginConfigurer.successHandler(oauthLoginSuccessHandler);
        });

        http.formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.permitAll().loginPage("/login"));
        http.logout(httpSecurityLogoutConfigurer -> {
            httpSecurityLogoutConfigurer.logoutUrl("/logout");
            httpSecurityLogoutConfigurer.logoutSuccessUrl("/");
            httpSecurityLogoutConfigurer.deleteCookies("true");
        });

        http.exceptionHandling(httpSecurityExceptionHandlingConfigurer -> httpSecurityExceptionHandlingConfigurer.accessDeniedPage("/403"));

        return http.build();
    }

}
