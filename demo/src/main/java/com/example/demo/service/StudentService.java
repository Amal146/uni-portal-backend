package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
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

    public StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setUserId(student.getUserId());
        dto.setMatricNumber(student.getMatricNumber());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setProgrammeId(student.getProgramme() != null ? student.getProgramme().getId() : null);
        dto.setStartSemester(student.getStartSemester());
        dto.setStartSeason(student.getStartSeason() != null ? student.getStartSeason().name() : null);
        dto.setStartYear(student.getStartYear());
        dto.setMaxYears(student.getMaxYears());
        dto.setMinEctsPerYear(student.getMinEctsPerYear());
        dto.setStatus(student.getStatus() != null ? student.getStatus().name() : null);
        dto.setRole(student.getRole() != null ? student.getRole().name() : null);
        return dto;
    }

    public StudentDTO getStudentDTOById(String id) {
        return toDTO(getStudentById(id));
    }

    public List<StudentDTO> getAllStudentDTOs() {
        return studentRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public StudentDTO getStudentDTOByEmail(String email) {
        return toDTO(getStudentByEmail(email));
    }

    public StudentDTO getStudentDTOByFullName(String firstName, String lastName) {
        return toDTO(getStudentByFullName(firstName, lastName));
    }

    public List<StudentDTO> getStudentDTOsByProgrammeId(String programmeId) {
        return studentRepository.findByProgrammeId(programmeId).stream()
                .map(this::toDTO)
                .toList();
    }

    public List<StudentDTO> getStudentDTOsByLastName(String lastName) {
        return studentRepository.findByLastName(lastName).stream()
                .map(this::toDTO)
                .toList();
    }
}