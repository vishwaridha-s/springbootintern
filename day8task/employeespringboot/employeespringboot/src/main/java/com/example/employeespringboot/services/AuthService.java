package com.example.employeespringboot.services;

import com.example.employeespringboot.models.RegisterDetails;
import com.example.employeespringboot.models.Roles;
import com.example.employeespringboot.models.UserDetailsDto;
import com.example.employeespringboot.repository.RegisterDetailsRepository;
import com.example.employeespringboot.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;
    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String addNewEmployee(UserDetailsDto register) {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setEmpId(register.getEmpId());
        registerDetails.setEmail(register.getEmail());
//        registerDetails.setGender(register.getGender());
//        registerDetails.setRole(register.getRole());
//        System.out.println("Password is"+register.getPassword()+"\n Encrypted Password is"+passwordEncoder.encode(register.getPassword()));
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setName(register.getName());
        registerDetails.setUserName(register.getUserName());
        Set<Roles> roles=new HashSet<>();
        for(String roleName: register.getRoleName()){
             Roles role=rolesRepository.findByName(roleName)
                             .orElseThrow(()-> new RuntimeException("Role not found"+roleName));
            roles.add(role);
        }
        registerDetails.setRoles(roles);
//        registerDetails.setDateOfBirth(register.getDateOfBirth());
        registerDetailsRepository.save(registerDetails);
        return "Employee added successfully";
    }

    public String authenticate(RegisterDetails login) {
        RegisterDetails user = registerDetailsRepository.findByEmail(login.getEmail());
        if(user!=null){
            if(passwordEncoder.matches(login.getPassword(),user.getPassword())){
                return "Login Successful";
            }else {
                return "Login not successfull";
            }
        }else{
            return "Login not successfull";
        }
    }
}