package com.ndt.spring.day_40.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


import lombok.Getter;
import lombok.Setter;


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
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;
}
