package com.example.reboot.services;

import com.example.reboot.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {

    List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(1, "Prashanth", "Trainer"),
                    new Employee(2, "Yuvraj", "Faculty")
            )
    );

    public List<Employee> helloWorld() {
        return employees;
    }

    public Employee getEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getUserid() == id) {
                return emp;
            }
        }
        return new Employee(); // Return empty if not found
    }

    public String putMethod() {
        return "PUT method called";
    }

    public String postMethod(Employee employee) {
        employees.add(employee);
        return "Employee added via postMethod";
    }

    public String deleteMethod(int id) {
        boolean removed = employees.removeIf(emp -> emp.getUserid() == id);
        return removed ? "Employee with ID " + id + " deleted." : "Employee not found.";
    }

    public String addEmployee(Employee emp) {
        employees.add(emp);
        return "Employee added: " + emp.getName();
    }

    public String updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getUserid() == updatedEmployee.getUserid()) {
                employees.set(i, updatedEmployee);
                return "Employee with ID " + updatedEmployee.getUserid() + " updated.";
            }
        }
        return "Employee with ID " + updatedEmployee.getUserid() + " not found.";
    }
}
