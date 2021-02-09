package com.spring.boot.basicauth.controllers;


import com.spring.boot.basicauth.model.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class StudentController {
    
    private static final List<Student> students = Arrays.asList(
            new Student(1L, "Megatron", "NLN", "megatron@email.com"),
            new Student(2L, "Optimus", "Prime", "optimusprime@email.com"),
            new Student(3L, "Iron", "Hide", "ironhide@email.com"),
            new Student(4L, "Vector", "Prime", "vectorprime@email.com")
    );

    @RequestMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        return students.stream().
                filter(student -> id.equals(student.getId())).
                findFirst().
                orElseThrow(() -> new NoSuchElementException("No Such a Id Exist."));
    }

}
