package com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q3;

import java.util.List;
import java.math.BigDecimal;

import jakarta.persistence.*;


import lombok.*;


@Getter
@Setter
@ToString
@Table(name = "course")
@Entity(name = "btJPA1Q3Course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(nullable = false)
    private BigDecimal duration;

    @ToString.Exclude
    @OneToMany(mappedBy = "course")
    private List<RegistrationEntity> registrations;
}
