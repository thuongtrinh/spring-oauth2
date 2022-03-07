package com.javadeveloperzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@SpringBootApplication
public class SpringBootOauth2Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootOauth2Application.class, args);
    }
}
