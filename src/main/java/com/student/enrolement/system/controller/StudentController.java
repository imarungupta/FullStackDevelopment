package com.student.enrolement.system.controller;

import com.student.enrolement.system.model.Student;
import com.student.enrolement.system.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    // Simple Post method just adding the record and return string messages
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        Student newStudent = studentService.saveStudent(student);
        if(newStudent!=null){
            return "New Student is added";
        }else
            return "Not Added ";
    }
    // Post method with ResponseEntity status, here we are creating the URI-location for newly created record
    @PostMapping("/addNewStudent")
    ResponseEntity<?> addNewStudent(@RequestBody Student student){

        Student newStudent = studentService.saveStudent(student);
        if(newStudent==null){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{studentId}").buildAndExpand(newStudent.getId()).toUri();

       System.out.println("location: "+ ResponseEntity.created(location).build());
        //return ResponseEntity.created(location).build();
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
