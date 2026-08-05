package com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q6;

import java.math.BigDecimal;

import jakarta.persistence.*;


import lombok.*;


@Getter
@Setter
@ToString
@Table(name = "employee")
@Entity(name = "btJPA2Q6Employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(precision = 19, scale = 6, nullable = false)
    private BigDecimal salary;

    @Column(length = 200, nullable = false)
    private String department;
}
