package com.txt.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
public class SpringOauth2ResourceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringOauth2ResourceServerApplication.class, args);
    }

}
