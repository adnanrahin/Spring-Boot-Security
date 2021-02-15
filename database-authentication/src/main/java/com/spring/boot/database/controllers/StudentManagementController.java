package com.spring.boot.database.controllers;

import com.spring.boot.database.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/")
public class StudentManagementController {

    private static final List<Student> students = Arrays.asList(
            new Student(1L, "Megatron", "NLN", "megatron@email.com"),
            new Student(2L, "Optimus", "Prime", "optimusprime@email.com"),
            new Student(3L, "Iron", "Hide", "ironhide@email.com"),
            new Student(4L, "Vector", "Prime", "vectorprime@email.com")
    );

    @RequestMapping(method = RequestMethod.GET, path = "/getAll")
    public List<Student> getAllStudents() {
        System.out.println("getAllStudents");
        return students;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("registerNewStudent");
        System.out.println(student);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("deleteStudent");
        System.out.println(studentId);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/update/{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        System.out.println("updateStudent");
        System.out.println(String.format("%s %s", studentId, student));
    }
}
