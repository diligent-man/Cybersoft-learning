package com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q8;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;


import lombok.*;


@Getter
@Setter
@ToString
@Table(name = "`order`")
@Entity(name = "btJPA2Q8Order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`customerName`", length = 200, nullable = false)
    private String customerName;

    @Column(name = "`totalAmount`", precision = 13, scale = 4, nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "`createdAt`", nullable = false)
    private LocalDateTime createdAt;
}
