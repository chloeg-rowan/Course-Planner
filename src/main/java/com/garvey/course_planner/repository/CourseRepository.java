package com.garvey.course_planner.repository;

import com.garvey.course_planner.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findBySemesterId(Long semesterId);

    Optional<Course> findByIdAndSemesterId(Long id, Long semesterId);

    List<Course> findByRequirementId(Long requirementId);

    // All courses belonging to a given user, across all their semesters.
    // Useful for cumulative GPA calculation (Step 8).
    @Query("SELECT c FROM Course c WHERE c.semester.user.id = :userId")
    List<Course> findAllByUserId(@Param("userId") Long userId);
}