package com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q1;

import jakarta.persistence.*;


import lombok.*;


@Getter
@Setter
@ToString
@Table(name = "students")
@Entity(name = "btJPA3Q1Student")
public class
StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String major;
}
