package com.example.demo.service;

import com.example.demo.dto.RegistrationDTO;
import com.example.demo.model.Course;
import com.example.demo.model.Registration;
import com.example.demo.model.RegistrationPeriod;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.RegistrationPeriodRepository;
import com.example.demo.repository.RegistrationRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Updated RegistrationService that returns DTOs
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final CourseRepository courseRepository;
    private final RegistrationPeriodRepository registrationPeriodRepository;

    public List<RegistrationDTO> getAllRegistrations() {
        return RegistrationDTO.fromEntities(registrationRepository.findAll());
    }

    public RegistrationDTO getRegistrationById(String id) {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found with id: " + id));
        return RegistrationDTO.fromEntity(registration);
    }

    @Transactional
    public RegistrationDTO createRegistration(RegistrationDTO registrationDTO) {
        Registration registration = convertToEntity(registrationDTO);
        if (registration.getId() == null) {
            registration.setId(java.util.UUID.randomUUID().toString());
        }
        Registration saved = registrationRepository.save(registration);
        return RegistrationDTO.fromEntity(saved);
    }

    @Transactional
    public RegistrationDTO updateRegistration(String id, RegistrationDTO registrationDetailsDTO) {
        Registration registration = getRegistrationEntityById(id);
        updateRegistrationEntity(registration, registrationDetailsDTO);
        Registration updated = registrationRepository.save(registration);
        return RegistrationDTO.fromEntity(updated);
    }

    @Transactional
    public void deleteRegistration(String id) {
        registrationRepository.deleteById(id);
    }

   
    public List<RegistrationDTO> getRegistrationsByCourseId(String courseId) {
        return RegistrationDTO.fromEntities(registrationRepository.findByCourseId(courseId));
    }

    public List<RegistrationDTO> getRegistrationsByRegistrationPeriodId(String periodId) {
        return RegistrationDTO.fromEntities(registrationRepository.findByRegistrationPeriodId(periodId));
    }

    

    
    // Helper methods for internal use
    private Registration getRegistrationEntityById(String id) {
        return registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found with id: " + id));
    }
    
    private Registration convertToEntity(RegistrationDTO dto) {
        Registration registration = new Registration();
        registration.setId(dto.getId());
        registration.setSeatsTotal(dto.getSeatsTotal());
       
        
        // Set Course if courseId is provided
        if (dto.getCourseId() != null) {
            Course course = courseRepository.findById(dto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.getCourseId()));
            registration.setCourse(course);
        }
        
        // Set RegistrationPeriod if registrationPeriodId is provided
        if (dto.getRegistrationPeriodId() != null) {
            RegistrationPeriod period = registrationPeriodRepository.findById(dto.getRegistrationPeriodId())
                    .orElseThrow(() -> new RuntimeException("RegistrationPeriod not found with id: " + dto.getRegistrationPeriodId()));
            registration.setRegistrationPeriod(period);
        }
        
        
        return registration;
    }
    
    private void updateRegistrationEntity(Registration registration, RegistrationDTO dto) {
        registration.setSeatsTotal(dto.getSeatsTotal());
        
      
        // Update Course if courseId is provided
        if (dto.getCourseId() != null) {
            Course course = courseRepository.findById(dto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.getCourseId()));
            registration.setCourse(course);
        }
        
        // Update RegistrationPeriod if registrationPeriodId is provided
        if (dto.getRegistrationPeriodId() != null) {
            RegistrationPeriod period = registrationPeriodRepository.findById(dto.getRegistrationPeriodId())
                    .orElseThrow(() -> new RuntimeException("RegistrationPeriod not found with id: " + dto.getRegistrationPeriodId()));
            registration.setRegistrationPeriod(period);
        }
       
    }
}
