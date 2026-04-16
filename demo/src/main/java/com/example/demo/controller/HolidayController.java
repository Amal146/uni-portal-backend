package com.example.demo.controller;

import com.example.demo.dto.HolidayDTO;
import com.example.demo.service.HolidayService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

// Updated HolidayController that returns DTOs
@RestController
@RequestMapping("/holidays")
@RequiredArgsConstructor
public class HolidayController {
    private final HolidayService holidayService;

    @GetMapping
    public ResponseEntity<List<HolidayDTO>> getAllHolidays() {
        return ResponseEntity.ok(holidayService.getAllHolidays());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HolidayDTO> getHolidayById(@PathVariable String id) {
        return ResponseEntity.ok(holidayService.getHolidayById(id));
    }

    @PostMapping
    public ResponseEntity<HolidayDTO> createHoliday(@RequestBody HolidayDTO holiday) {
        return new ResponseEntity<>(holidayService.createHoliday(holiday), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HolidayDTO> updateHoliday(@PathVariable String id, @RequestBody HolidayDTO holiday) {
        return ResponseEntity.ok(holidayService.updateHoliday(id, holiday));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHoliday(@PathVariable String id) {
        holidayService.deleteHoliday(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/semester/{semesterId}")
    public ResponseEntity<List<HolidayDTO>> getHolidaysBySemesterId(@PathVariable String semesterId) {
        return ResponseEntity.ok(holidayService.getHolidaysBySemesterId(semesterId));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<HolidayDTO>> getHolidaysByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(holidayService.getHolidaysByDate(date));
    }

    @GetMapping("/between")
    public ResponseEntity<List<HolidayDTO>> getHolidaysBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(holidayService.getHolidaysBetweenDates(startDate, endDate));
    }
}