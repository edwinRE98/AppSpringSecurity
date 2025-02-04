package com.app.controllers;

import jakarta.annotation.security.PermitAll;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
//Denegar cualquier endpoint que no esté configurado
@PreAuthorize("denyAll()")
public class TestAuthController {

    @GetMapping("/hello")
    //Este endpoint es publíco
    @PreAuthorize("permitAll()")
    public String test(){
        return "Hello World";
    }

    @GetMapping("/security")
    //El usuario que intente entrar a este endpoint "security" debe tener la autorización de "create"
    @PreAuthorize("hasAuthority('create')")
    public String testSecond(){
        return "Spring Security";
    }
}