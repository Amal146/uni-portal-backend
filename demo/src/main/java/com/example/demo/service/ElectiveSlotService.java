package com.example.demo.service;

import com.example.demo.model.ElectiveSlot;
import com.example.demo.repository.ElectiveSlotRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ElectiveSlotService {
    
    @Autowired
    private ElectiveSlotRepository electiveSlotRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    public List<ElectiveSlot> getSlotsByStudent(String studentId) {
        return electiveSlotRepository.findByStudentId(studentId);
    }
    
    public List<ElectiveSlot> getSlotsByStudentAndType(String studentId, ElectiveSlot.ElectiveType type) {
        return electiveSlotRepository.findByStudentIdAndType(studentId, type);
    }
    
    public List<ElectiveSlot> getSlotsByStudentAndStatus(String studentId, ElectiveSlot.ElectiveStatus status) {
        return electiveSlotRepository.findByStudentIdAndStatus(studentId, status);
    }
    
    @Transactional
    public ElectiveSlot createElectiveSlot(ElectiveSlot slot) {
        studentRepository.findById(slot.getStudent().getId())
            .orElseThrow(() -> new RuntimeException("Student not found"));
        return electiveSlotRepository.save(slot);
    }
    
    @Transactional
    public ElectiveSlot assignCourseToSlot(String slotId, String courseId) {
        ElectiveSlot slot = electiveSlotRepository.findById(slotId)
            .orElseThrow(() -> new RuntimeException("Elective slot not found"));
        
        courseRepository.findById(courseId)
            .orElseThrow(() -> new RuntimeException("Course not found"));
        
        slot.setStatus(ElectiveSlot.ElectiveStatus.registered);
        return electiveSlotRepository.save(slot);
    }
    
    @Transactional
    public void deleteElectiveSlot(String id) {
        electiveSlotRepository.deleteById(id);
    }
}
