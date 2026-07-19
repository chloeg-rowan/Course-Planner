package com.garvey.course_planner.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "degree_requirements")
public class DegreeRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String category; // e.g. "Major Core", "Elective", "Gen Ed"

    @Column(name = "required_credits", nullable = false)
    private BigDecimal requiredCredits;

    @OneToMany(mappedBy = "requirement")
    private List<Course> courses = new ArrayList<>();

    public DegreeRequirement() {
    }

    public DegreeRequirement(User user, String category, BigDecimal requiredCredits) {
        this.user = user;
        this.category = category;
        this.requiredCredits = requiredCredits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getRequiredCredits() {
        return requiredCredits;
    }

    public void setRequiredCredits(BigDecimal requiredCredits) {
        this.requiredCredits = requiredCredits;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}