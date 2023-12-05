package com.txt.oauth2.github.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestAppController {

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    @GetMapping(value = "/principal")
    public String sayHello(@AuthenticationPrincipal OAuth2User principal) {
        return "Hello, " + principal.getAttribute("name");
    }

    @GetMapping(value = "/getAuthentication", produces = "application/json")
    public String getAuthentication(OAuth2AuthenticationToken authenticaiton) {
        return authenticaiton.toString();
    }

    @GetMapping(value = "/getEmails", produces = "application/json")
    public String getEmails(OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(),
                authentication.getPrincipal().getName());

        String getEmailUrl = "https://api.github.com/user/emails";

        // send HTTP request to get user emails
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken().getTokenValue());
        HttpEntity entity = new HttpEntity("", headers);
        ResponseEntity response = restTemplate.exchange(getEmailUrl, HttpMethod.GET, entity, String.class);
        return response.getBody().toString();
    }

}
