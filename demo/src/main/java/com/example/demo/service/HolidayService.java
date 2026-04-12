package com.example.demo.service;

import com.example.demo.model.Holiday;
import com.example.demo.repository.HolidayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HolidayService {
    private final HolidayRepository holidayRepository;

    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }

    public Holiday getHolidayById(String id) {
        return holidayRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Holiday not found with id: " + id));
    }

    @Transactional
    public Holiday createHoliday(Holiday holiday) {
        if (holiday.getId() == null) {
            holiday.setId(UUID.randomUUID().toString());
        }
        return holidayRepository.save(holiday);
    }

    @Transactional
    public Holiday updateHoliday(String id, Holiday holidayDetails) {
        Holiday holiday = getHolidayById(id);
        holiday.setType(holidayDetails.getType());
        holiday.setTitle(holidayDetails.getTitle());
        holiday.setDate(holidayDetails.getDate());
        holiday.setDescription(holidayDetails.getDescription());
        holiday.setSemester(holidayDetails.getSemester());
        return holidayRepository.save(holiday);
    }

    @Transactional
    public void deleteHoliday(String id) {
        holidayRepository.deleteById(id);
    }

    public List<Holiday> getHolidaysBySemesterId(String semesterId) {
        return holidayRepository.findBySemesterId(semesterId);
    }

    public List<Holiday> getHolidaysByDate(LocalDate date) {
        return holidayRepository.findByDate(date);
    }

    public List<Holiday> getHolidaysBetweenDates(LocalDate startDate, LocalDate endDate) {
        return holidayRepository.findHolidaysBetweenDates(startDate, endDate);
    }
}