package com.example.emp.controller;

import com.example.emp.model.RegisterDetails;
import com.example.emp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String addNewUser(@RequestBody RegisterDetails reg) {
        return authService.addNewUser(reg);
    }

    @PostMapping("/login")
    public String login(@RequestBody RegisterDetails loginDetails) {
        return authService.authenticate(loginDetails);
    }
}
