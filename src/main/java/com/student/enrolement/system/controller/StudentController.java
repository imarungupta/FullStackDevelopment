package com.student.enrolement.system.controller;

import com.student.enrolement.system.model.Student;
import com.student.enrolement.system.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    //-------------------------------Create-------------------------------------------------------------
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        Student newStudent = studentService.saveStudent(student);
        if (newStudent != null) {
            return "New Student is added::"+student.getId();
        } else
            return "Not Added ";
    }
    //-----------------------------Create With Http Status----------------------------------------------
    // Post method with ResponseEntity status, here we are creating the URI-location for newly created record
    @PostMapping("/addNewStudentWithLocation")
    ResponseEntity<?> addNewStudent(@RequestBody Student student) {

        Student newStudent = studentService.saveStudent(student);
        if (newStudent == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{studentId}").buildAndExpand(newStudent.getId()).toUri();

        System.out.println("location: " + ResponseEntity.created(location).build());
        //return ResponseEntity.created(location).build();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    //----------------------------------Read All Record from DB------------------------------------------------
    @GetMapping("/getAllStudent")
    public List<Student> getStudentList() {
        List<Student> allStudent = studentService.getAllStudent();
        return allStudent;
    }
    //------------------------------Simple Read Operation by id-------------------------------------------------
    @GetMapping("/getAnyStudentById/{id}")
    public Student getOneStudent(@PathVariable Integer id) {
        Student oneStudent = studentService.getOneStudent(id);
        return oneStudent;
    }
    //------------------------------Read Operation by id with Http Status---------------------------------------
    @GetMapping("/getAnyStudentByIdWithURI/{studentId}")
    public ResponseEntity<Student> getOneStudent1(@PathVariable Integer studentId) {
        try {
            Student oneStudent = studentService.getOneStudent(studentId);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .buildAndExpand(studentId).toUri();
            System.out.println("Location ::" + ResponseEntity.created(location).build());
            return new ResponseEntity<Student>(oneStudent, HttpStatus.OK);

        } catch (NoSuchElementException e) {

            URI location1 = ServletUriComponentsBuilder.fromCurrentRequest()
                    .buildAndExpand(studentId).toUri();
            System.out.println("Location ::" + ResponseEntity.created(location1).build());
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }
    //------------------------------Update Operation--------------------------------------------------------
    @PutMapping("/updateOneStudent/{studentId}")
    public ResponseEntity<Student> updateOneStudent(@RequestBody Student student, @PathVariable Integer studentId) {
        URI updateURI = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(studentId).toUri();
        try {
            int oneStudent = student.getId();
            System.out.println("Inside if condition -id "+ oneStudent);
            if (oneStudent != studentId) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            studentService.updateStudent(studentId);
            studentService.saveStudent(student);

            System.out.println("Updated URI::" + ResponseEntity.created(updateURI).build());

            return new ResponseEntity<Student>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            //URI updateURI = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(studentId).toUri();
            System.out.println("Updated URI::" + updateURI + "Not Matched");

            return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
        }
    }
    //------------------------------Delete By Id Operation--------------------------------------------------------
    @DeleteMapping("deleteWithHttpStatus/{studentId}")
    public ResponseEntity<Student> deleteOneStudent(@RequestBody Student student, @PathVariable Integer studentId) {
        URI delUriLoc = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(studentId).toUri();
        System.out.println("Deleted URI::" + ResponseEntity.created(delUriLoc).build() +" id ::::" + studentId);

        if (studentId == student.getId()) {
            try {
                studentService.deleteOneStudent(studentId);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("delById/{studentId}")
    public String deleteOneStudent1(@RequestBody Student student, @PathVariable Integer studentId){
        studentService.deleteOneStudent(studentId);
        return "The deleted record id is::" +studentId;
    }
}
