package com.ndt.spring.day_40.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;


@Entity(name = "users")
public class UserEntity {
    @Id
    private String id;

    private String email;

    private String password;

    private LocalDateTime createDate;
}
