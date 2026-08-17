package com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q2;

import java.math.BigDecimal;

import jakarta.persistence.*;


import lombok.*;


@Getter
@Setter
@ToString
@Table(name = "product")
@Entity(name = "btJPA3Q2Product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false, unique = true, columnDefinition = "VARCHAR(200) COLLATE utf8mb4_0900_as_cs")
    private String name;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    private String description;
}
