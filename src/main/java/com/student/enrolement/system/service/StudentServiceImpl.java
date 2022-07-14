package com.student.enrolement.system.service;

import com.student.enrolement.system.model.Student;
import com.student.enrolement.system.repository.StudentRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentServiceInterface{

    // Inject the Repository so that we can use its method here in this impl class
    @Autowired
    private StudentRepositoryInterface studentRepositoryInterface;
    @Override
    public Student saveStudent(Student student) {
        Student saveStudentRecord = studentRepositoryInterface.save(student);
        return saveStudentRecord;
    }
    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList = studentRepositoryInterface.findAll();
        return studentList;
    }

    @Override
    public Student getOneStudent(int studentId) {
        Student getOneStudentDetail = studentRepositoryInterface.findById(studentId).get();
        return getOneStudentDetail;
    }
    @Override
    public void  updateStudent(int id) {
        studentRepositoryInterface.findById(id);
    }
    @Override
    public void deleteOneStudent(int id) {
        studentRepositoryInterface.deleteById(id);
    }


}
