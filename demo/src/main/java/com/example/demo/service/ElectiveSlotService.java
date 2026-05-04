package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.ElectiveSlot;
import com.example.demo.model.Semester;
import com.example.demo.model.Student;
import com.example.demo.repository.ElectiveSlotRepository;
import com.example.demo.repository.SemesterRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.dto.ElectiveSlotDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Updated ElectiveSlotService that returns DTOs
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ElectiveSlotService {
    private final ElectiveSlotRepository electiveSlotRepository;
    private final StudentRepository studentRepository;
    private final SemesterRepository semesterRepository;
    private final CourseRepository courseRepository;

    public List<ElectiveSlotDTO> getAllElectiveSlots() {
        return ElectiveSlotDTO.fromEntities(electiveSlotRepository.findAll());
    }

    public ElectiveSlotDTO getElectiveSlotById(String id) {
        ElectiveSlot electiveSlot = electiveSlotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ElectiveSlot not found with id: " + id));
        return ElectiveSlotDTO.fromEntity(electiveSlot);
    }

    @Transactional
    public ElectiveSlotDTO createElectiveSlot(ElectiveSlotDTO electiveSlotDTO) {
        ElectiveSlot electiveSlot = convertToEntity(electiveSlotDTO);
        if (electiveSlot.getId() == null) {
            electiveSlot.setId(java.util.UUID.randomUUID().toString());
        }
        ElectiveSlot saved = electiveSlotRepository.save(electiveSlot);
        return ElectiveSlotDTO.fromEntity(saved);
    }

    @Transactional
    public ElectiveSlotDTO updateElectiveSlot(String id, ElectiveSlotDTO slotDetailsDTO) {
        ElectiveSlot slot = getElectiveSlotEntityById(id);
        updateElectiveSlotEntity(slot, slotDetailsDTO);
        ElectiveSlot updated = electiveSlotRepository.save(slot);
        return ElectiveSlotDTO.fromEntity(updated);
    }

    @Transactional
    public void deleteElectiveSlot(String id) {
        electiveSlotRepository.deleteById(id);
    }

    public List<ElectiveSlotDTO> getSlotsByStudentId(String studentId) {
        return ElectiveSlotDTO.fromEntities(electiveSlotRepository.findByStudentId(studentId));
    }

    public List<ElectiveSlotDTO> getSlotsByStudentIdAndType(String studentId, String type) {
        ElectiveSlot.ElectiveType typeEnum = ElectiveSlot.ElectiveType.valueOf(type);
        return ElectiveSlotDTO.fromEntities(electiveSlotRepository.findByStudentIdAndType(studentId, typeEnum));
    }

   

    public List<ElectiveSlotDTO> getSlotsBySelectedCourseId(String courseId) {
        return ElectiveSlotDTO.fromEntities(electiveSlotRepository.findBySelectedCourseId(courseId));
    }
    
    // Helper methods for internal use
    private ElectiveSlot getElectiveSlotEntityById(String id) {
        return electiveSlotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ElectiveSlot not found with id: " + id));
    }
    
    private ElectiveSlot convertToEntity(ElectiveSlotDTO dto) {
        ElectiveSlot electiveSlot = new ElectiveSlot();
        electiveSlot.setId(dto.getId());
        electiveSlot.setLabel(dto.getLabel());
        electiveSlot.setSlotNumber(dto.getSlotNumber());
        electiveSlot.setPlannedSlot(dto.getPlannedSlot());
        
        // Set Student if studentId is provided
        if (dto.getStudentId() != null) {
            Student student = studentRepository.findById(dto.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found with id: " + dto.getStudentId()));
            electiveSlot.setStudent(student);
        }
        
        // Set Type if type is provided
        if (dto.getType() != null) {
            electiveSlot.setType(ElectiveSlot.ElectiveType.valueOf(dto.getType()));
        }
        
        // Set PlannedSemester if plannedSemesterId is provided
        if (dto.getPlannedSemesterId() != null) {
            Semester semester = semesterRepository.findById(dto.getPlannedSemesterId())
                    .orElseThrow(() -> new RuntimeException("Semester not found with id: " + dto.getPlannedSemesterId()));
            electiveSlot.setPlannedSemester(semester);
        }
        
        // Set SelectedCourse if selectedCourseId is provided
        if (dto.getSelectedCourseId() != null) {
            Course course = courseRepository.findById(dto.getSelectedCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.getSelectedCourseId()));
            electiveSlot.setSelectedCourse(course);
        }
        
        
        
        return electiveSlot;
    }
    
    private void updateElectiveSlotEntity(ElectiveSlot electiveSlot, ElectiveSlotDTO dto) {
    electiveSlot.setLabel(dto.getLabel());
    electiveSlot.setSlotNumber(dto.getSlotNumber());
    electiveSlot.setPlannedSlot(dto.getPlannedSlot());

    // Always update — null clears the relationship
    if (dto.getStudentId() != null) {
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found: " + dto.getStudentId()));
        electiveSlot.setStudent(student);
    }

    electiveSlot.setType(dto.getType() != null
            ? ElectiveSlot.ElectiveType.valueOf(dto.getType())
            : null);

    // Null explicitly clears the semester
    if (dto.getPlannedSemesterId() != null) {
        Semester semester = semesterRepository.findById(dto.getPlannedSemesterId())
                .orElseThrow(() -> new RuntimeException("Semester not found: " + dto.getPlannedSemesterId()));
        electiveSlot.setPlannedSemester(semester);
    } else {
        electiveSlot.setPlannedSemester(null); // ← this was missing
    }

    // Null explicitly clears the course
    if (dto.getSelectedCourseId() != null) {
        Course course = courseRepository.findById(dto.getSelectedCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found: " + dto.getSelectedCourseId()));
        electiveSlot.setSelectedCourse(course);
    } else {
        electiveSlot.setSelectedCourse(null); // ← this was missing
    }

 
}
}