package com.example.emp.service;

import com.example.emp.Repository.RegisterDetailsRepository;
import com.example.emp.model.RegisterDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private RegisterDetailsRepository rep;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addNewUser(RegisterDetails register) {
        // Encrypt password before saving
        register.setPassword(passwordEncoder.encode(register.getPassword()));
        rep.save(register);
        return "User added successfully";
    }

    public String authenticate(RegisterDetails login) {
        RegisterDetails user = rep.findByEmail(login.getEmail());

        if (user != null) {
            if (passwordEncoder.matches(login.getPassword(), user.getPassword())) {
                return "Login successful";
            } else {
                return "Invalid password";
            }
        }
        return "User not found";
    }
}
