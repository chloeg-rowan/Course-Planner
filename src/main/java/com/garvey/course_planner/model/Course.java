package com.garvey.course_planner.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semester_id", nullable = false)
    private Semester semester;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requirement_id")
    private DegreeRequirement requirement; // nullable

    @Column(name = "course_code", nullable = false)
    private String courseCode; // e.g. "CS 301"

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(nullable = false)
    private BigDecimal credits;

    @Column
    private String grade; // nullable, letter grade, null if in progress

    public Course() {
    }

    public Course(Semester semester, String courseCode, String courseName, BigDecimal credits) {
        this.semester = semester;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public DegreeRequirement getRequirement() {
        return requirement;
    }

    public void setRequirement(DegreeRequirement requirement) {
        this.requirement = requirement;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public BigDecimal getCredits() {
        return credits;
    }

    public void setCredits(BigDecimal credits) {
        this.credits = credits;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}