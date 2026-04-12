package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @Transactional
    public Student createStudent(Student student) {
        if (student.getId() == null) {
            student.setId(UUID.randomUUID().toString());
        }
        return studentRepository.save(student);
    }

    @Transactional
    public Student updateStudent(String id, Student studentDetails) {
        Student student = getStudentById(id);
        student.setUserId(studentDetails.getUserId());
        student.setMatricNumber(studentDetails.getMatricNumber());
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setEmail(studentDetails.getEmail());
        student.setProgramme(studentDetails.getProgramme());
        student.setStartSemester(studentDetails.getStartSemester());
        student.setStartSeason(studentDetails.getStartSeason());
        student.setStartYear(studentDetails.getStartYear());
        student.setMaxYears(studentDetails.getMaxYears());
        student.setMinEctsPerYear(studentDetails.getMinEctsPerYear());
        student.setStatus(studentDetails.getStatus());
        student.setRole(studentDetails.getRole());
        return studentRepository.save(student);
    }

    @Transactional
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentsByProgrammeId(String programmeId) {
        return studentRepository.findByProgrammeId(programmeId);
    }

    public List<Student> getStudentsByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Student not found with email: " + email));
    }

    public Student getStudentByFullName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(() -> new RuntimeException("Student not found with name: " + firstName + " " + lastName));
    }
}