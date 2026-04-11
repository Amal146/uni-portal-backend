package com.example.demo.service;

import com.example.demo.model.Holiday;
import com.example.demo.repository.HolidayRepository;
import com.example.demo.repository.SemesterMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HolidayService {
    
    @Autowired
    private HolidayRepository holidayRepository;
    
    @Autowired
    private SemesterMetaRepository semesterMetaRepository;
    
    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }
    
    public Optional<Holiday> getHolidayById(String id) {
        return holidayRepository.findById(id);
    }
    
    public List<Holiday> getHolidaysBySemester(String semesterId) {
        return holidayRepository.findBySemesterId(semesterId);
    }
    
    public List<Holiday> getHolidaysByDate(LocalDate date) {
        return holidayRepository.findByDate(date);
    }
    
    public List<Holiday> getHolidaysBetweenDates(LocalDate startDate, LocalDate endDate) {
        return holidayRepository.findHolidaysBetweenDates(startDate, endDate);
    }
    
    @Transactional
    public Holiday createHoliday(Holiday holiday) {
        if (holiday.getSemester() != null && holiday.getSemester().getId() != null) {
            semesterMetaRepository.findById(holiday.getSemester().getId())
                .orElseThrow(() -> new RuntimeException("Semester not found"));
        }
        return holidayRepository.save(holiday);
    }
    
    @Transactional
    public Holiday updateHoliday(String id, Holiday holidayDetails) {
        Holiday holiday = holidayRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Holiday not found"));
        
        if (holidayDetails.getTitle() != null) holiday.setTitle(holidayDetails.getTitle());
        if (holidayDetails.getDate() != null) holiday.setDate(holidayDetails.getDate());
        if (holidayDetails.getDescription() != null) holiday.setDescription(holidayDetails.getDescription());
        if (holidayDetails.getType() != null) holiday.setType(holidayDetails.getType());
        
        return holidayRepository.save(holiday);
    }
    
    @Transactional
    public void deleteHoliday(String id) {
        holidayRepository.deleteById(id);
    }
}