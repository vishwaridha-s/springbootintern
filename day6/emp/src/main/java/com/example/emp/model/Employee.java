package com.example.emp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    private String name;
    private String job;

    public Employee() {}

    public Employee(int userid, String name, String job) {
        this.userid = userid;
        this.name = name;
        this.job = job;
    }
}
