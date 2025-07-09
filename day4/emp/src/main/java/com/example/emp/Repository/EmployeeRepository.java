package com.example.emp.Repository;

import com.example.emp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // No extra code needed unless custom query
}
