package com.student.enrolement.system.service;

import com.student.enrolement.system.model.Student;

import java.util.List;

public interface StudentServiceInterface  {
    public Student saveStudent(Student student);
    public List<Student> getAllStudent();
    public Student getOneStudent(int id);
    public void updateStudent(int id);
    public void deleteOneStudent(int id);
}
