package com.example.reboot.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {
    // Getters and Setters
    private int userid;
    private String name;
    private String job;

    // Parameterized constructor
    public Employee(int userid, String name, String job) {
        this.userid = userid;
        this.name = name;
        this.job = job;
    }

    public Employee() {

    }

}
