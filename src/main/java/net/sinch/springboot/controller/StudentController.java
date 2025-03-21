package net.sinch.springboot.controller;

import net.sinch.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

//  1. Spring Boot REST API returns - Java Bean
//  2. Using Spring ResponseEntity to Manipulate the HTTP Response
//  http://localhost:8080/student
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
      Student student = new Student(1, "Sinchana", "P Gudagi");
//      Using - ResponseEntity
//      return new ResponseEntity<>(student, HttpStatus.OK)

//        Using - ok method
//      return ResponseEntity.ok(student);

//        Using - ok method with header
        return ResponseEntity.ok().header("custom-header", "sinchana").body(student);
    }

//    Spring Boot REST API That Returns - List
//    http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Lily", "Daisy"));
        students.add(new Student(2, "Rose", "Jack"));
        students.add(new Student(3, "Marie", "Peter"));
        students.add(new Student(4, "Jasmine", "Jaz"));
        return ResponseEntity.ok(students);
    }

//    Spring Boot REST API with Path Variable - @PathVariable
//    {id} - URI template variable
//    http://localhost:8080/students/1
    @GetMapping("/{id}/{first-name}/{last-name}")
//    public Student studentPathVariable(@PathVariable int id) {
//        return new Student(id, "new-user-firstName", "new-user-lastName");
//    }
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

//    Spring Boot REST API with Request Param - @RequestParam
//    http://localhost:8080/students/query?id=1
    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestParam(@RequestParam int id) {
        Student student = new Student(id, "new-user-firstName", "new-user-lastName");
        return ResponseEntity.ok(student);
    }


    //    http://localhost:8080/students/queries?id=1&firstName=Sinchana&lastName=P Gudagi
    @GetMapping("/queries")
    public ResponseEntity<Student> studentRequestParams(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

//    Spring Boot POST REST API - @PostMapping and @RequestBody
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

//     Spring Boot PUT REST API - @PutMapping and @RequestBody
    @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@PathVariable int id ,@RequestBody Student student) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

//     Spring Boot DELETE REST API - @DeleteMapping
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        return ResponseEntity.ok("Deleted student id - " + id);
    }
}


