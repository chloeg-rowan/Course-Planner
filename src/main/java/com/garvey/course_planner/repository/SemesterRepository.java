package com.garvey.course_planner.repository;

import com.garvey.course_planner.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SemesterRepository extends JpaRepository<Semester, Long> {

    List<Semester> findByUserId(Long userId);

    Optional<Semester> findByIdAndUserId(Long id, Long userId);

    // Basic search support (used later in Step 10)
    List<Semester> findByUserIdAndTermIgnoreCaseAndYear(Long userId, String term, int year);
}