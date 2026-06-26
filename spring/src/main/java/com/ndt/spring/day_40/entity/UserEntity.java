package com.ndt.spring.day_40.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;


import lombok.*;


@Getter
@Setter
@Entity(name = "users")
public class UserEntity {
    @Id
    private String id;

    private String email;

    private String password;

    private LocalDateTime createDate;

    // Nếu bảng nào giữ FK thì @ManyToOne và @JoinColumn
    // Sol 1: use @JsonIgnore to ignore this field during serialization (can be in 1 side or N side)
    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;
}
