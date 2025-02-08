package com.app.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/security/users")
public class TestAuthController {

    //Endpoint de acceso público
    @GetMapping("/getPublic")
    public String getPublic(){
        return "This endpoint is public.";
    }

    //Endpoint de acceso para usuario administrador y usuario estándar
    @GetMapping("/get")
    public String standardUser(){
        return "This user has permission to read.";
    }

    //Endpoint de acceso para usuario administrador
    @PostMapping("/post")
    public String postMessage(){
        return "This user has permission to create.";
    }

    //Endpoint de acceso para usuario administrador
    @PutMapping("/put")
    public String putMessage(){
        return "This user has permission to update.";
    }

    //Endpoint de acceso para usuario administrador
    @DeleteMapping("/delete")
    public String deleteMessage(){
        return "This user has permission to delete.";
    }
}