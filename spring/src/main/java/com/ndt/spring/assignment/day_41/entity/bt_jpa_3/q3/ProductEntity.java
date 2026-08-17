package com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q3;

import java.math.BigDecimal;

import jakarta.persistence.*;


import lombok.*;


@Getter
@Setter
@ToString
@Table(name = "products")
@Entity(name = "btJPA3Q3Product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
