package com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q5;

import java.util.List;

import jakarta.persistence.*;


import lombok.*;


@Getter
@Setter
@ToString
@Table(name = "student")
@Entity(name = "btJPA1Q5Student")
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
    @OneToMany(mappedBy = "student")
    private List<RegistrationEntity> registrations;
}
