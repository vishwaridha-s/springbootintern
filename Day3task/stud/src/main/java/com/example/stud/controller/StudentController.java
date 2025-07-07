package com.example.stud.controller;

import com.example.stud.model.Student;
import com.example.stud.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService ss;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return ss.getAllStudents();
    }

    @PutMapping("/")
    public String updateStudent(@RequestBody Student student) {
        return ss.updateStudent(student);
    }

    @PostMapping("/")
    public String createStudent(@RequestBody Student student) {
        return ss.createStudent(student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        return ss.deleteStudent(id);
    }

    @PostMapping("/student")
    public String addStudent(@RequestBody Student s) {
        return ss.addStudent(s);
    }
}
