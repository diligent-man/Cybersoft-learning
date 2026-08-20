package com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q4;

import java.util.Set;
import java.util.HashSet;

import java.math.BigDecimal;

import jakarta.persistence.*;


import lombok.*;


@Getter
@Setter
@ToString
@Table(name = "course")
@Entity(name = "btJPA1Q4Course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(nullable = false)
    private BigDecimal duration;

    @ToString.Exclude
    @ManyToMany(mappedBy = "courses")
    private Set<StudentEntity> students = new HashSet<>();
}
