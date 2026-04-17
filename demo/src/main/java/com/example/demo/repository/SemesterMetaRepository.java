package com.example.demo.repository;

import com.example.demo.model.SemesterMeta;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SemesterMetaRepository extends JpaRepository<SemesterMeta, String> {
    List<SemesterMeta> findBySeason(SemesterMeta.Season season);
    List<SemesterMeta> findByCalYear(Integer calYear);
    List<SemesterMeta> findByStatus(SemesterMeta.SemesterStatus status);
    Optional<SemesterMeta> findByLabelAndCalYear(String label, Integer calYear);
}