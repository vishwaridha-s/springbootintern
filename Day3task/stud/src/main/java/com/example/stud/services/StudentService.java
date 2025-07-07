package com.example.stud.services;

import com.example.stud.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    List<Student> studentList = new ArrayList<>();

    public List<Student> getAllStudents() {
        return studentList;
    }

    public String updateStudent(Student s) {
        for (Student st : studentList) {
            if (st.getStudentId() == s.getStudentId()) {
                st.setName(s.getName());
                st.setCourse(s.getCourse());
                return "Student updated";
            }
        }
        return "Student not found";
    }

    public String createStudent(Student s) {
        studentList.add(s);
        return "Student created";
    }

    public String deleteStudent(int id) {
        for (Student st : studentList) {
            if (st.getStudentId() == id) {
                studentList.remove(st);
                return "Student deleted";
            }
        }
        return "Student not found";
    }

    public String addStudent(Student s) {
        studentList.add(s);
        return "Student added via /student endpoint";
    }
}
