package com.dima.springsecuritystudying.rest_controller;

import com.dima.springsecuritystudying.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMIN_TRAINEE')")
    public List<Student> getAllStudents() {
        System.out.println("GET");
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void insertStudent(@RequestBody Student student) {
        System.out.println("POST");
        System.out.println(student);
    }

    @DeleteMapping( "{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable(name = "id") Integer studentId) {
        System.out.println("DELETE");
        System.out.println(studentId);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable(name = "id") Integer studentId, @RequestBody Student student) {
        System.out.println("PUT");
        System.out.println(studentId + " " + student);
    }
}
