package com.txt.service.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
public class ServiceController {

    @Autowired
    @Qualifier("messagingClientClientCredsRestTemplate")
    private OAuth2RestTemplate messagingClientAuthCodeRestTemplate;

    @GetMapping(value = "/test")
    public String getShipmentDetails(@RequestParam(value = "name", defaultValue = "0") String name) {
        ResponseEntity<String> result = messagingClientAuthCodeRestTemplate.postForEntity("http://localhost:9081/hello", name, String.class);
        return result.getBody();
    }

}
