package com.example.demo.repository;

import com.example.demo.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, String> {

    List<Semester> findBySeason(Semester.Season season);

    List<Semester> findByCalYear(Integer calYear);

    List<Semester> findByStatus(String status);

    Optional<Semester> findByLabelAndCalYear(String label, Integer calYear);
}