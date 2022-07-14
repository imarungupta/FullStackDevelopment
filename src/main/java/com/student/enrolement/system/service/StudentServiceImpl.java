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
    public List<Student> findAllStudent() {
        return null;
    }
    @Override
    public Student findOneStudent(int id) {
        return null;
    }
}
