package com.example.employeespringboot.controllers;

import com.example.employeespringboot.models.Employee;
import com.example.employeespringboot.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/e")
public class HelloWorldController {
    @Autowired
    HelloWorldService hws;
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/")
    public String routes(){
        return "welcome to spring boot security";
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/e")
    public List<Employee> getMethod(){
        return hws.getMethod();
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/e/role/{role}")
    public List<Employee> getMethodByRole(@PathVariable String role){
        return hws.getMethodByRole(role);
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/e/{empId}")
    public Employee getMethodById(@PathVariable int empId){
        return hws.getMethodById(empId);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/e")
    public String putMethod( @RequestBody Employee employee){
        return  hws.updateEmployee(employee);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/e")
    public String addEmployee(@RequestBody Employee employee){

         hws.addEmployee(employee);
         return "Employee added successfully!!!";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/e/{empId}")
    public String deleteMethodById(@PathVariable int empId){
         hws.deleteMethodById(empId);
         return "deleted";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/e")
    public String deleteMethod(){
        hws.deleteMethod();
        return "deleted";
    }
}
