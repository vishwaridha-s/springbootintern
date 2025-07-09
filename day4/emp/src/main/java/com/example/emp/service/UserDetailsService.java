package com.example.emp.service;

import com.example.emp.Repository.UserRepo;
import com.example.emp.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    public UserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserDetails> getAllUser() {
        return userRepo.findAll();
    }

    public UserDetails findById(int id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User with ID " + id + " not found"));
    }

    public boolean AddUser(UserDetails userDetails) {
        userRepo.save(userDetails);
        return true;
    }

    public boolean delete(UserDetails userDetails) {
        userRepo.delete(userDetails);
        return true;
    }

    public boolean update(int id, UserDetails userDetails) {
        userDetails.setEmpid(id);
        userRepo.save(userDetails);
        return true;
    }
}

