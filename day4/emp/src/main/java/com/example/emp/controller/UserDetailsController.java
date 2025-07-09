package com.example.emp.controller;

import com.example.emp.model.UserDetails;
import com.example.emp.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserDetailsController {

    @Autowired
    private UserDetailsService uds;  // ✅ Use your custom service

    // Get all users
    @GetMapping
    public List<UserDetails> getAllUsers() {
        return uds.getAllUser();
    }

    // Get user by ID
    @GetMapping("{id}")
    public UserDetails getUserById(@PathVariable int id) {
        return uds.findById(id);
    }

    // Add new user
    @PostMapping
    public String addUser(@RequestBody UserDetails userDetails) {
        return uds.AddUser(userDetails) ? "Success" : "Fail";
    }

    // Delete user
    @DeleteMapping
    public String deleteUser(@RequestBody UserDetails userDetails) {
        return uds.delete(userDetails) ? "Success" : "Fail";
    }

    // Update user
    @PutMapping("{id}")
    public String updateUser(@PathVariable int id, @RequestBody UserDetails userDetails) {
        return uds.update(id, userDetails) ? "Success" : "Fail";
    }
}
