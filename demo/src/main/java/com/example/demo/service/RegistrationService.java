package com.example.demo.service;

import com.example.demo.model.Registration;
import com.example.demo.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegistrationService {
    private final RegistrationRepository registrationRepository;

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Registration getRegistrationById(String id) {
        return registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found with id: " + id));
    }

    @Transactional
    public Registration createRegistration(Registration registration) {
        if (registration.getId() == null) {
            registration.setId(UUID.randomUUID().toString());
        }
        return registrationRepository.save(registration);
    }

    @Transactional
    public Registration updateRegistration(String id, Registration registrationDetails) {
        Registration registration = getRegistrationById(id);
        registration.setStudent(registrationDetails.getStudent());
        registration.setCourse(registrationDetails.getCourse());
        registration.setRegistrationPeriod(registrationDetails.getRegistrationPeriod());
        registration.setSeatsAvailable(registrationDetails.getSeatsAvailable());
        registration.setSeatsTotal(registrationDetails.getSeatsTotal());
        registration.setPrerequisites(registrationDetails.getPrerequisites());
        registration.setPrereqsMet(registrationDetails.getPrereqsMet());
        registration.setStatus(registrationDetails.getStatus());
        return registrationRepository.save(registration);
    }

    @Transactional
    public void deleteRegistration(String id) {
        registrationRepository.deleteById(id);
    }

    public List<Registration> getRegistrationsByStudentId(String studentId) {
        return registrationRepository.findByStudentId(studentId);
    }

    public List<Registration> getRegistrationsByCourseId(String courseId) {
        return registrationRepository.findByCourseId(courseId);
    }

    public List<Registration> getRegistrationsByRegistrationPeriodId(String periodId) {
        return registrationRepository.findByRegistrationPeriodId(periodId);
    }

    public List<Registration> getRegistrationsByStudentIdAndStatus(String studentId, Registration.RegistrationStatus status) {
        return registrationRepository.findByStudentIdAndStatus(studentId, status);
    }

    public Registration getRegistrationByStudentIdAndCourseId(String studentId, String courseId) {
        return registrationRepository.findByStudentIdAndCourseId(studentId, courseId)
                .orElseThrow(() -> new RuntimeException("Registration not found"));
    }
}