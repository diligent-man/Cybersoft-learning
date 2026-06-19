package com.ndt.spring.day_40.entity;

import java.time.LocalDateTime;


import lombok.*;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;


@Setter
@Getter
@ToString
@Entity(name = "roles")
public class RoleEntity {
    @Id
    private Integer id;

    private String name;

    private LocalDateTime createdDate;
}
