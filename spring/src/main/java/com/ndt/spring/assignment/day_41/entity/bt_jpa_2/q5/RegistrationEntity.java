package com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q5;

import jakarta.persistence.*;

import lombok.*;


@Getter
@Setter
@ToString
@Table(name = "registration")
@Entity(name = "btJPA2Q5Registration")
public class RegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseEntity course;
}
