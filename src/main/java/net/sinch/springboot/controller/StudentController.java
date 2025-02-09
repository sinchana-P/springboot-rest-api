package net.sinch.springboot.controller;

import net.sinch.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(1, "Sinchana", "P Gudagi");
        return student;
    }
}
