package com.example.demo.repository;

import com.example.demo.model.RegistrationPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationPeriodRepository extends JpaRepository<RegistrationPeriod, String> {
    List<RegistrationPeriod> findBySemesterId(String semesterId);
    List<RegistrationPeriod> findByType(RegistrationPeriod.RegistrationType type);
    List<RegistrationPeriod> findByStatus(RegistrationPeriod.RegistrationStatus status);
    
    @Query("SELECT r FROM RegistrationPeriod r WHERE r.openDate <= :date AND r.closeDate >= :date")
    Optional<RegistrationPeriod> findActiveRegistrationPeriod(@Param("date") LocalDate date);
}