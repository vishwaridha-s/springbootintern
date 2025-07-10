package com.example.emp.controller;

import com.example.emp.model.UserDetails;
import com.example.emp.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")  // ✅ This must match the secured path
public class UserDetailsController {

    @Autowired
    private UserDetailsService uds;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<UserDetails> getAllUsers() {
        return uds.getAllUser();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public UserDetails getUserById(@PathVariable int id) {
        return uds.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String addUser(@RequestBody UserDetails userDetails) {
        return uds.AddUser(userDetails) ? "Success" : "Fail";
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@RequestBody UserDetails userDetails) {
        return uds.delete(userDetails) ? "Success" : "Fail";
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateUser(@PathVariable int id, @RequestBody UserDetails userDetails) {
        return uds.update(id, userDetails) ? "Success" : "Fail";
    }
}
