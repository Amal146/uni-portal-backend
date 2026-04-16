package com.example.demo.service;

import com.example.demo.dto.RegistrationPeriodDTO;
import com.example.demo.model.RegistrationPeriod;
import com.example.demo.model.Semester;
import com.example.demo.repository.RegistrationPeriodRepository;
import com.example.demo.repository.SemesterRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

// Updated RegistrationPeriodService that returns DTOs
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegistrationPeriodService {
    private final RegistrationPeriodRepository registrationPeriodRepository;
    private final SemesterRepository semesterRepository;

    public List<RegistrationPeriodDTO> getAllRegistrationPeriods() {
        return RegistrationPeriodDTO.fromEntities(registrationPeriodRepository.findAll());
    }

    public RegistrationPeriodDTO getRegistrationPeriodById(String id) {
        RegistrationPeriod period = registrationPeriodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RegistrationPeriod not found with id: " + id));
        return RegistrationPeriodDTO.fromEntity(period);
    }

    @Transactional
    public RegistrationPeriodDTO createRegistrationPeriod(RegistrationPeriodDTO periodDTO) {
        RegistrationPeriod period = convertToEntity(periodDTO);
        if (period.getId() == null) {
            period.setId(java.util.UUID.randomUUID().toString());
        }
        RegistrationPeriod saved = registrationPeriodRepository.save(period);
        return RegistrationPeriodDTO.fromEntity(saved);
    }

    @Transactional
    public RegistrationPeriodDTO updateRegistrationPeriod(String id, RegistrationPeriodDTO periodDetailsDTO) {
        RegistrationPeriod period = getRegistrationPeriodEntityById(id);
        updateRegistrationPeriodEntity(period, periodDetailsDTO);
        RegistrationPeriod updated = registrationPeriodRepository.save(period);
        return RegistrationPeriodDTO.fromEntity(updated);
    }

    @Transactional
    public void deleteRegistrationPeriod(String id) {
        registrationPeriodRepository.deleteById(id);
    }

    public List<RegistrationPeriodDTO> getPeriodsBySemesterId(String semesterId) {
        return RegistrationPeriodDTO.fromEntities(registrationPeriodRepository.findBySemesterId(semesterId));
    }

    public List<RegistrationPeriodDTO> getPeriodsByType(String type) {
        RegistrationPeriod.RegistrationType typeEnum = RegistrationPeriod.RegistrationType.valueOf(type);
        return RegistrationPeriodDTO.fromEntities(registrationPeriodRepository.findByType(typeEnum));
    }

    public List<RegistrationPeriodDTO> getPeriodsByStatus(String status) {
        RegistrationPeriod.RegistrationStatus statusEnum = RegistrationPeriod.RegistrationStatus.valueOf(status);
        return RegistrationPeriodDTO.fromEntities(registrationPeriodRepository.findByStatus(statusEnum));
    }

    public RegistrationPeriodDTO getActiveRegistrationPeriod() {
        RegistrationPeriod period = registrationPeriodRepository.findActiveRegistrationPeriod(LocalDate.now())
                .orElseThrow(() -> new RuntimeException("No active registration period found"));
        return RegistrationPeriodDTO.fromEntity(period);
    }
    
    // Helper methods for internal use
    private RegistrationPeriod getRegistrationPeriodEntityById(String id) {
        return registrationPeriodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RegistrationPeriod not found with id: " + id));
    }
    
    private RegistrationPeriod convertToEntity(RegistrationPeriodDTO dto) {
        RegistrationPeriod period = new RegistrationPeriod();
        period.setId(dto.getId());
        period.setOpenDate(dto.getOpenDate());
        period.setCloseDate(dto.getCloseDate());
        period.setDeregDeadline(dto.getDeregDeadline());
        
        // Set Semester if semesterId is provided
        if (dto.getSemesterId() != null) {
            Semester semester = semesterRepository.findById(dto.getSemesterId())
                    .orElseThrow(() -> new RuntimeException("Semester not found with id: " + dto.getSemesterId()));
            period.setSemester(semester);
        }
        
        // Set Type if type is provided
        if (dto.getType() != null) {
            period.setType(RegistrationPeriod.RegistrationType.valueOf(dto.getType()));
        }
        
        // Set Status if status is provided
        if (dto.getStatus() != null) {
            period.setStatus(RegistrationPeriod.RegistrationStatus.valueOf(dto.getStatus()));
        }
        
        return period;
    }
    
    private void updateRegistrationPeriodEntity(RegistrationPeriod period, RegistrationPeriodDTO dto) {
        period.setOpenDate(dto.getOpenDate());
        period.setCloseDate(dto.getCloseDate());
        period.setDeregDeadline(dto.getDeregDeadline());
        
        // Update Semester if semesterId is provided
        if (dto.getSemesterId() != null) {
            Semester semester = semesterRepository.findById(dto.getSemesterId())
                    .orElseThrow(() -> new RuntimeException("Semester not found with id: " + dto.getSemesterId()));
            period.setSemester(semester);
        }
        
        // Update Type if type is provided
        if (dto.getType() != null) {
            period.setType(RegistrationPeriod.RegistrationType.valueOf(dto.getType()));
        }
        
        // Update Status if status is provided
        if (dto.getStatus() != null) {
            period.setStatus(RegistrationPeriod.RegistrationStatus.valueOf(dto.getStatus()));
        }
    }
}
