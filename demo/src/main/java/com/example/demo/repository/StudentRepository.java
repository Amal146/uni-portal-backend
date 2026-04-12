package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByProgrammeId(String programmeId);
    List<Student> findByLastName(String lastName);
    List<Student> findByStatus(String status);
    Optional<Student> findByEmail(String email);
    Optional<Student> findByFirstNameAndLastName(String firstName, String lastName);
    
}