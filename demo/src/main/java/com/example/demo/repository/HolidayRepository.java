package com.example.demo.repository;

import com.example.demo.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, String> {
    List<Holiday> findBySemesterId(String semesterId);
    List<Holiday> findByDate(LocalDate date);
    
    @Query("SELECT h FROM Holiday h WHERE h.date BETWEEN :startDate AND :endDate")
    List<Holiday> findHolidaysBetweenDates(@Param("startDate") LocalDate startDate, 
                                           @Param("endDate") LocalDate endDate);
}