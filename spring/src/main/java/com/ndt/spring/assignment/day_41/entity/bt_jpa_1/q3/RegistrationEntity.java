package com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q3;

import java.time.LocalDate;

import jakarta.persistence.*;


import lombok.*;


@Getter
@Setter
@ToString
@Table(name = "registration")
@Entity(name = "btJPA1Q3Registration")
public class RegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate registrationDate;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseEntity course;


    @PrePersist
    protected void onCreate() {
        if (registrationDate == null) {
            registrationDate = LocalDate.now();
        }
    }
}
