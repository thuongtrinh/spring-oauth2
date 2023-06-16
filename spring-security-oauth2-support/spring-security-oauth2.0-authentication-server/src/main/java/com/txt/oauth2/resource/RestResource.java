package com.txt.oauth2.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class RestResource {

    @RequestMapping("/demo")
    public String demo(Principal principal) {
        return "Hello " + principal.getName() + ", Auth 2.0 Resource Server, Access Granted by authentication server..";
    }
}
