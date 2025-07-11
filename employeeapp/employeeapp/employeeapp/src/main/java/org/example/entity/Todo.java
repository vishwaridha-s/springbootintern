package org.example.entity;

import jakarta.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String task;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public Long getId() { return id; }
    public String getTask() { return task; }
    public Employee getEmployee() { return employee; }

    public void setId(Long id) { this.id = id; }
    public void setTask(String task) { this.task = task; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}
