package com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q3;

import java.math.BigDecimal;

import jakarta.persistence.*;


import lombok.*;


@Getter
@Setter
@ToString
@Table(name = "book")
@Entity(name = "btJPA2Q3Book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(length = 200, nullable = false)
    private String author;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;
}
