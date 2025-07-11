package com.example.employeespringboot.controllers;

import com.example.employeespringboot.models.RegisterDetails;
import com.example.employeespringboot.models.UserDetailsDto;
import com.example.employeespringboot.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping ("/r")
public String addNewEmployee(@RequestBody UserDetailsDto register){
       authService.addNewEmployee(register);

    return "Employee Registered Successfully";
}
    @PostMapping("/l")
    public String Login(@RequestBody RegisterDetails login){

        return  authService.authenticate(login);
    }

}

