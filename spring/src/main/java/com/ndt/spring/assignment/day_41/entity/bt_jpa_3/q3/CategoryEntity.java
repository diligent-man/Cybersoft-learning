package com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q3;

import jakarta.persistence.*;


import lombok.*;


@Getter
@Setter
@ToString
@Table(name = "categories")
@Entity(name = "btJPA3Q3Category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String name;
}
