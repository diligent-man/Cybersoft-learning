package com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q9;

import jakarta.persistence.*;

import lombok.*;


@Getter
@Setter
@ToString
@Table(name = "customer")
@Entity(name = "btJPA2Q9Customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 200, nullable = false, unique = true)
    private String email;

    @Column(length = 11, nullable = false, unique = true)
    private String phone;
}
