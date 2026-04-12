package com.example.demo.service;

import com.example.demo.model.RegistrationPeriod;
import com.example.demo.repository.RegistrationPeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegistrationPeriodService {
    private final RegistrationPeriodRepository registrationPeriodRepository;

    public List<RegistrationPeriod> getAllRegistrationPeriods() {
        return registrationPeriodRepository.findAll();
    }

    public RegistrationPeriod getRegistrationPeriodById(String id) {
        return registrationPeriodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RegistrationPeriod not found with id: " + id));
    }

    @Transactional
    public RegistrationPeriod createRegistrationPeriod(RegistrationPeriod period) {
        if (period.getId() == null) {
            period.setId(UUID.randomUUID().toString());
        }
        return registrationPeriodRepository.save(period);
    }

    @Transactional
    public RegistrationPeriod updateRegistrationPeriod(String id, RegistrationPeriod periodDetails) {
        RegistrationPeriod period = getRegistrationPeriodById(id);
        period.setSemester(periodDetails.getSemester());
        period.setType(periodDetails.getType());
        period.setOpenDate(periodDetails.getOpenDate());
        period.setCloseDate(periodDetails.getCloseDate());
        period.setDeregDeadline(periodDetails.getDeregDeadline());
        period.setStatus(periodDetails.getStatus());
        return registrationPeriodRepository.save(period);
    }

    @Transactional
    public void deleteRegistrationPeriod(String id) {
        registrationPeriodRepository.deleteById(id);
    }

    public List<RegistrationPeriod> getPeriodsBySemesterId(String semesterId) {
        return registrationPeriodRepository.findBySemesterId(semesterId);
    }

    public List<RegistrationPeriod> getPeriodsByType(RegistrationPeriod.RegistrationType type) {
        return registrationPeriodRepository.findByType(type);
    }

    public List<RegistrationPeriod> getPeriodsByStatus(RegistrationPeriod.RegistrationStatus status) {
        return registrationPeriodRepository.findByStatus(status);
    }

    public RegistrationPeriod getActiveRegistrationPeriod() {
        return registrationPeriodRepository.findActiveRegistrationPeriod(LocalDate.now())
                .orElseThrow(() -> new RuntimeException("No active registration period found"));
    }
}