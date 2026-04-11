package com.example.demo.repository;

import com.example.demo.model.ElectiveRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ElectiveRuleRepository extends JpaRepository<ElectiveRule, String> {
    List<ElectiveRule> findByProgrammeId(String programmeId);
    List<ElectiveRule> findByProgrammeIdAndType(String programmeId, ElectiveRule.ElectiveType type);
}