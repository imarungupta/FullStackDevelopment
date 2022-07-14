package com.student.enrolement.system.service;

import com.student.enrolement.system.model.Student;

import java.util.List;

public interface StudentServiceInterface  {
    public Student saveStudent(Student student);
    public List<Student> findAllStudent();
    public Student findOneStudent(int id);
}
