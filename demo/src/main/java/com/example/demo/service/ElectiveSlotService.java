package com.example.demo.service;

import com.example.demo.model.ElectiveSlot;
import com.example.demo.repository.ElectiveSlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ElectiveSlotService {
    private final ElectiveSlotRepository electiveSlotRepository;

    public List<ElectiveSlot> getAllElectiveSlots() {
        return electiveSlotRepository.findAll();
    }

    public ElectiveSlot getElectiveSlotById(String id) {
        return electiveSlotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ElectiveSlot not found with id: " + id));
    }

    @Transactional
    public ElectiveSlot createElectiveSlot(ElectiveSlot electiveSlot) {
        if (electiveSlot.getId() == null) {
            electiveSlot.setId(UUID.randomUUID().toString());
        }
        return electiveSlotRepository.save(electiveSlot);
    }

    @Transactional
    public ElectiveSlot updateElectiveSlot(String id, ElectiveSlot slotDetails) {
        ElectiveSlot slot = getElectiveSlotById(id);
        slot.setStudent(slotDetails.getStudent());
        slot.setType(slotDetails.getType());
        slot.setLabel(slotDetails.getLabel());
        slot.setSlotNumber(slotDetails.getSlotNumber());
        slot.setPlannedSlot(slotDetails.getPlannedSlot());
        slot.setPlannedSemester(slotDetails.getPlannedSemester());
        slot.setSelectedCourse(slotDetails.getSelectedCourse());
        slot.setStatus(slotDetails.getStatus());
        return electiveSlotRepository.save(slot);
    }

    @Transactional
    public void deleteElectiveSlot(String id) {
        electiveSlotRepository.deleteById(id);
    }

    public List<ElectiveSlot> getSlotsByStudentId(String studentId) {
        return electiveSlotRepository.findByStudentId(studentId);
    }

    public List<ElectiveSlot> getSlotsByStudentIdAndType(String studentId, ElectiveSlot.ElectiveType type) {
        return electiveSlotRepository.findByStudentIdAndType(studentId, type);
    }

    public List<ElectiveSlot> getSlotsByStudentIdAndStatus(String studentId, ElectiveSlot.ElectiveStatus status) {
        return electiveSlotRepository.findByStudentIdAndStatus(studentId, status);
    }

    public List<ElectiveSlot> getSlotsBySelectedCourseId(String courseId) {
        return electiveSlotRepository.findBySelectedCourseId(courseId);
    }
}