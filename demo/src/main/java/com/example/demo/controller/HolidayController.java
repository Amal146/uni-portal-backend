package com.example.demo.controller;

import com.example.demo.model.Holiday;
import com.example.demo.service.HolidayService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/holidays")
@RequiredArgsConstructor
public class HolidayController {
    private final HolidayService holidayService;

    @GetMapping
    public ResponseEntity<List<Holiday>> getAllHolidays() {
        return ResponseEntity.ok(holidayService.getAllHolidays());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Holiday> getHolidayById(@PathVariable String id) {
        return ResponseEntity.ok(holidayService.getHolidayById(id));
    }

    @PostMapping
    public ResponseEntity<Holiday> createHoliday(@RequestBody Holiday holiday) {
        return new ResponseEntity<>(holidayService.createHoliday(holiday), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Holiday> updateHoliday(@PathVariable String id, @RequestBody Holiday holiday) {
        return ResponseEntity.ok(holidayService.updateHoliday(id, holiday));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHoliday(@PathVariable String id) {
        holidayService.deleteHoliday(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/semester/{semesterId}")
    public ResponseEntity<List<Holiday>> getHolidaysBySemesterId(@PathVariable String semesterId) {
        return ResponseEntity.ok(holidayService.getHolidaysBySemesterId(semesterId));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Holiday>> getHolidaysByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(holidayService.getHolidaysByDate(date));
    }

    @GetMapping("/between")
    public ResponseEntity<List<Holiday>> getHolidaysBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(holidayService.getHolidaysBetweenDates(startDate, endDate));
    }
}