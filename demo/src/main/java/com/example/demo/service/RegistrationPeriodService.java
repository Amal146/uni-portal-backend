package com.example.demo.service;

import com.example.demo.model.RegistrationPeriod;
import com.example.demo.repository.RegistrationPeriodRepository;
import com.example.demo.repository.SemesterMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationPeriodService {
    
    @Autowired
    private RegistrationPeriodRepository registrationPeriodRepository;
    
    @Autowired
    private SemesterMetaRepository semesterMetaRepository;
    
    public List<RegistrationPeriod> getPeriodsBySemester(String semesterId) {
        return registrationPeriodRepository.findBySemesterId(semesterId);
    }
    
    public List<RegistrationPeriod> getPeriodsByType(RegistrationPeriod.RegistrationType type) {
        return registrationPeriodRepository.findByType(type);
    }
    
    public Optional<RegistrationPeriod> getActivePeriod(LocalDate date) {
        return registrationPeriodRepository.findActiveRegistrationPeriod(date);
    }
    
    @Transactional
    public RegistrationPeriod createPeriod(RegistrationPeriod period) {
        semesterMetaRepository.findById(period.getSemester().getId())
            .orElseThrow(() -> new RuntimeException("Semester not found"));
        return registrationPeriodRepository.save(period);
    }
    
    @Transactional
    public RegistrationPeriod updatePeriod(String id, RegistrationPeriod periodDetails) {
        RegistrationPeriod period = registrationPeriodRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Registration period not found"));
        
        if (periodDetails.getOpenDate() != null) period.setOpenDate(periodDetails.getOpenDate());
        if (periodDetails.getCloseDate() != null) period.setCloseDate(periodDetails.getCloseDate());
        if (periodDetails.getStatus() != null) period.setStatus(periodDetails.getStatus());
        
        return registrationPeriodRepository.save(period);
    }
}