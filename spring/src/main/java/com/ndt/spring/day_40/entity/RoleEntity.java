package com.ndt.spring.day_40.entity;

import java.util.List;
import java.time.LocalDateTime;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


import lombok.*;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Setter
@Getter
@ToString
@Entity(name = "roles")
public class RoleEntity {
    @Id
    private Integer id;

    private String name;

    private LocalDateTime createdDate;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<UserEntity> users;
}
