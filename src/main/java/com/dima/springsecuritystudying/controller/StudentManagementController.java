package com.dima.springsecuritystudying.controller;

import com.dima.springsecuritystudying.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );

    @GetMapping
    public List<Student> getAllStudents() {
        System.out.println("GET");
        return STUDENTS;
    }

    @PostMapping
    public void insertStudent(@RequestBody Student student) {
        System.out.println("POST");
        System.out.println(student);
    }

    @DeleteMapping( "{id}")
    public void deleteStudent(@PathVariable(name = "id") Integer studentId) {
        System.out.println("DELETE");
        System.out.println(studentId);
    }

    @PutMapping("{id}")
    public void updateStudent(@PathVariable(name = "id") Integer studentId, @RequestBody Student student) {
        System.out.println("PUT");
        System.out.println(studentId + " " + student);
    }
}
