package com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q7;

import jakarta.persistence.*;

import lombok.*;


@Getter
@Setter
@ToString
@Table(name = "user")
@Entity(name = "btJPA2Q7User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String username;

    @Column(length = 200, nullable = false, unique = true)
    private String email;

    @Column(length = 60, nullable = false)
    private String password;
}
