package com.example.emp.service;

import com.example.emp.model.Employee;
import com.example.emp.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloWorldService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> helloWorld() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public String postMethod(Employee employee) {
        employeeRepository.save(employee);
        return "Employee added via postMethod";
    }

    public String deleteMethod(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Employee with ID " + id + " deleted.";
        } else {
            return "Employee not found.";
        }
    }

    public String addEmployee(Employee emp) {
        employeeRepository.save(emp);
        return "Employee added: " + emp.getName();
    }

    public String updateEmployee(Employee updatedEmployee) {
        if (employeeRepository.existsById(updatedEmployee.getUserid())) {
            employeeRepository.save(updatedEmployee);
            return "Employee with ID " + updatedEmployee.getUserid() + " updated.";
        } else {
            return "Employee with ID " + updatedEmployee.getUserid() + " not found.";
        }
    }
}
