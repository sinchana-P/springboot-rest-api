package net.sinch.springboot.controller;

import net.sinch.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

//    Spring Boot REST API returns - Java Bean
//    http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent() {
//        Student student = new Student(1, "Sinchana", "P Gudagi");
//        return student;
        return new Student(1, "Sinchana", "P Gudagi");
    }

//    Spring Boot REST API That Returns - List
//    http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Lily", "Daisy"));
        students.add(new Student(2, "Rose", "Jack"));
        students.add(new Student(3, "Marie", "Peter"));
        students.add(new Student(4, "Jasmine", "Jaz"));
        return students;
    }

//    Spring Boot REST API with Path Variable - @PathVariable
//    {id} - URI template variable
//    http://localhost:8080/students/1
    @GetMapping("/students/{id}/{first-name}/{last-name}")
//    public Student studentPathVariable(@PathVariable int id) {
//        return new Student(id, "new-user-firstName", "new-user-lastName");
//    }
    public Student studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

//    Spring Boot REST API with Request Param - @RequestParam
//    http://localhost:8080/students/query?id=1
    @GetMapping("/students/query")
    public Student studentRequestParam(@RequestParam int id) {
        return new Student(id, "new-user-firstName", "new-user-lastName");
    }


    //    http://localhost:8080/students/queries?id=1&firstName=Sinchana&lastName=P Gudagi
    @GetMapping("/students/queries")
    public Student studentRequestParams(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }
}


