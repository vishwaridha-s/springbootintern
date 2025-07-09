package com.example.emp.controller;

import com.example.emp.model.Employee;
import com.example.emp.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    HelloWorldService hws;

    @GetMapping("/h")
    public List<Employee> hello() {
        return hws.helloWorld();
    }

    @PutMapping("/")
    public String putMethod(@RequestBody Employee employee) {
        return hws.updateEmployee(employee);
    }

    @PostMapping("/")
    public String postMethod(@RequestBody Employee employee) {
        return hws.postMethod(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteMethod(@PathVariable int id) {
        return hws.deleteMethod(id);
    }

    @PostMapping("/employee")
    public String addEmployee(@RequestBody Employee emp) {
        return hws.addEmployee(emp);
    }
}
