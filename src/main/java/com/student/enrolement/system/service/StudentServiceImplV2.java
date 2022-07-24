package com.student.enrolement.system.service;

import com.student.enrolement.system.model.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class StudentServiceImplV2 implements StudentServiceInterface{
    @Override
    public Student saveStudent(Student student) {
        return null;
    }
    @Override
    public List<Student> getAllStudent() {
        return null;
    }
    @Override
    public Student getOneStudent(int id) {
        return null;
    }
    @Override
    public void updateStudent(int id) {
    }
    @Override
    public void deleteOneStudent(int id) {

    }
}
