package com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q5;

import jakarta.persistence.*;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@Table(name = "course")
@Entity(name = "btJPA2Q5Course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String title;

    @ToString.Exclude
    @OneToMany(mappedBy = "course")
    private List<RegistrationEntity> registrations;
}
