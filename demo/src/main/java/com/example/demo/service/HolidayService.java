package com.example.demo.service;

import com.example.demo.dto.HolidayDTO;
import com.example.demo.model.Holiday;
import com.example.demo.model.Semester;
import com.example.demo.repository.HolidayRepository;
import com.example.demo.repository.SemesterRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

// Updated HolidayService that returns DTOs
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HolidayService {
    private final HolidayRepository holidayRepository;
    private final SemesterRepository semesterRepository;

    public List<HolidayDTO> getAllHolidays() {
        return HolidayDTO.fromEntities(holidayRepository.findAll());
    }

    public HolidayDTO getHolidayById(String id) {
        Holiday holiday = holidayRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Holiday not found with id: " + id));
        return HolidayDTO.fromEntity(holiday);
    }

    @Transactional
    public HolidayDTO createHoliday(HolidayDTO holidayDTO) {
        Holiday holiday = convertToEntity(holidayDTO);
        if (holiday.getId() == null) {
            holiday.setId(java.util.UUID.randomUUID().toString());
        }
        Holiday saved = holidayRepository.save(holiday);
        return HolidayDTO.fromEntity(saved);
    }

    @Transactional
    public HolidayDTO updateHoliday(String id, HolidayDTO holidayDetailsDTO) {
        Holiday holiday = getHolidayEntityById(id);
        updateHolidayEntity(holiday, holidayDetailsDTO);
        Holiday updated = holidayRepository.save(holiday);
        return HolidayDTO.fromEntity(updated);
    }

    @Transactional
    public void deleteHoliday(String id) {
        holidayRepository.deleteById(id);
    }

    public List<HolidayDTO> getHolidaysBySemesterId(String semesterId) {
        return HolidayDTO.fromEntities(holidayRepository.findBySemesterId(semesterId));
    }

    public List<HolidayDTO> getHolidaysByDate(LocalDate date) {
        return HolidayDTO.fromEntities(holidayRepository.findByDate(date));
    }

    public List<HolidayDTO> getHolidaysBetweenDates(LocalDate startDate, LocalDate endDate) {
        return HolidayDTO.fromEntities(holidayRepository.findHolidaysBetweenDates(startDate, endDate));
    }
    
    // Helper methods for internal use
    private Holiday getHolidayEntityById(String id) {
        return holidayRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Holiday not found with id: " + id));
    }
    
    private Holiday convertToEntity(HolidayDTO dto) {
        Holiday holiday = new Holiday();
        holiday.setId(dto.getId());
        holiday.setTitle(dto.getTitle());
        holiday.setDate(dto.getDate());
        holiday.setDescription(dto.getDescription());
        holiday.setTime(dto.getTime());
        holiday.setRoom(dto.getRoom());
        holiday.setCourseId(dto.getCourseId());
        holiday.setExamId(dto.getExamId());
        
        // Set Type if type is provided
        if (dto.getType() != null) {
            holiday.setType(Holiday.HolidayType.valueOf(dto.getType()));
        }
        
        // Set Semester if semesterId is provided
        if (dto.getSemesterId() != null) {
            Semester semester = semesterRepository.findById(dto.getSemesterId())
                    .orElseThrow(() -> new RuntimeException("Semester not found with id: " + dto.getSemesterId()));
            holiday.setSemester(semester);
        }
        
        return holiday;
    }
    
    private void updateHolidayEntity(Holiday holiday, HolidayDTO dto) {
        holiday.setTitle(dto.getTitle());
        holiday.setDate(dto.getDate());
        holiday.setDescription(dto.getDescription());
        holiday.setTime(dto.getTime());
        holiday.setRoom(dto.getRoom());
        holiday.setCourseId(dto.getCourseId());
        holiday.setExamId(dto.getExamId());
        
        // Update Type if type is provided
        if (dto.getType() != null) {
            holiday.setType(Holiday.HolidayType.valueOf(dto.getType()));
        }
        
        // Update Semester if semesterId is provided
        if (dto.getSemesterId() != null) {
            Semester semester = semesterRepository.findById(dto.getSemesterId())
                    .orElseThrow(() -> new RuntimeException("Semester not found with id: " + dto.getSemesterId()));
            holiday.setSemester(semester);
        }
    }
}
