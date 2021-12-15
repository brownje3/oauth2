package com.brownSecurity.oauth2.controllers;

import com.brownSecurity.oauth2.DTOs.RegistrationDTO;
import com.brownSecurity.oauth2.models.*;
import com.brownSecurity.oauth2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<MyUser> authenticate(){

        return null;
    }

    @GetMapping(value = "/login")
    public String showForm(){
        return "index";
    }

    @PostMapping(value = "/register")
    public ResponseEntity<MyUser> registerUser(RegistrationDTO registrationDTO){
        return new ResponseEntity<>(userService.registerUser(registrationDTO), HttpStatus.CREATED);
    }
}
