package com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q4;

import jakarta.persistence.*;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@Table(name = "category")
@Entity(name = "btJPA2Q4Category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String name;
}
