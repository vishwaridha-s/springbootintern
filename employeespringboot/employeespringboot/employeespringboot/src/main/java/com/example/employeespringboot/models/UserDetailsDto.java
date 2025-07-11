package com.example.employeespringboot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {
    private int empId;
    private String name;
    private String email;
    private String password;
    private String userName;
    private Set<String> roleName;
}
