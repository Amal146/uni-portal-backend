package com.example.demo.repository;

import com.example.demo.model.ThesisPrerequisite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ThesisPrerequisiteRepository extends JpaRepository<ThesisPrerequisite, String> {
    List<ThesisPrerequisite> findByProgrammeId(String programmeId);
    List<ThesisPrerequisite> findByModuleId(String moduleId);
}