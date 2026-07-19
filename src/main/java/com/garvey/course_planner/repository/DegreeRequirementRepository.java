package com.garvey.course_planner.repository;

import com.garvey.course_planner.model.DegreeRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DegreeRequirementRepository extends JpaRepository<DegreeRequirement, Long> {

    List<DegreeRequirement> findByUserId(Long userId);

    Optional<DegreeRequirement> findByIdAndUserId(Long id, Long userId);
}