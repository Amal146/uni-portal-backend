package com.example.demo.service;


import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }
    
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    
    public Student updateStudent(String id, Student studentDetails) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));
        
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setMatriculationNumber(studentDetails.getMatriculationNumber());
        student.setProgramme(studentDetails.getProgramme());
        student.setStartSeason(studentDetails.getStartSeason());
        student.setStartYear(studentDetails.getStartYear());
        student.setMaxYears(studentDetails.getMaxYears());
        
        return studentRepository.save(student);
    }
    
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
    
    public List<Student> getStudentsByProgramme(String programmeId) {
        return studentRepository.findByProgrammeId(programmeId);
    }
    
    public List<Student> searchByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }
}