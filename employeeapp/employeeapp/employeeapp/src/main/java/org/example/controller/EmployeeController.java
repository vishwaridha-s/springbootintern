package org.example.controller;

import org.example.entity.Employee;
import org.example.entity.Todo;
import org.example.repository.EmployeeRepository;
import org.example.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private TodoRepository todoRepo;

    @PostMapping
    public String createEmployee(@RequestBody Employee employee) {
        employeeRepo.save(employee);
        return "Employee created with name: " + employee.getName();
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee updatedData) {
        Optional<Employee> optionalEmp = employeeRepo.findById(id);
        if (optionalEmp.isPresent()) {
            Employee existingEmp = optionalEmp.get();
            existingEmp.setName(updatedData.getName());
            existingEmp.setRole(updatedData.getRole());
            employeeRepo.save(existingEmp);
            return "Employee updated successfully.";
        } else {
            return "Employee not found with ID: " + id;
        }
    }

    @GetMapping("/role/{role}")
    public List<Employee> getEmployeesByRole(@PathVariable String role) {
        return employeeRepo.findByRole(role);
    }

    @GetMapping("/{id}/todos")
    public List<Todo> getTodosByEmployee(@PathVariable Long id) {
        return todoRepo.findByEmployeeId(id);
    }

    @PostMapping("/{id}/todos")
    public String addTodoToEmployee(@PathVariable Long id, @RequestBody Todo todo) {
        Optional<Employee> optionalEmp = employeeRepo.findById(id);
        if (optionalEmp.isPresent()) {
            todo.setEmployee(optionalEmp.get());
            todoRepo.save(todo);
            return "Todo added successfully.";
        } else {
            return "Employee not found with ID: " + id;
        }
    }
}
