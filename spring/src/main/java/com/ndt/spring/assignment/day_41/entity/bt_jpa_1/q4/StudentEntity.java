package com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q4;

import java.util.Set;
import java.util.HashSet;


import jakarta.persistence.*;


import lombok.*;


@Getter
@Setter
@ToString
@Table(name = "student")
@Entity(name = "btJPA1Q4Student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer age;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
        name = "registration",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id"),
        uniqueConstraints = @UniqueConstraint(
            name = "UQ_student_course_registration",
            columnNames = {"student_id", "course_id"}
        )
    )
    private Set<CourseEntity> courses = new HashSet<>();
}
