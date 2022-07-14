package com.student.enrolement.system.repository;

import com.student.enrolement.system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryInterface extends JpaRepository<Student, Integer> {
    // 1- Annotate this class with @Repository
    // 2- extends the JpaRepository and then given the Model class and its primary key(id) data type
}
