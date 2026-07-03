package com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q1;


import jakarta.persistence.*;


import lombok.*;


@Getter
@Setter
@Entity(name = "userss")
public class UserEntity {
    @Id
    private String id;

    private String email;

    private String password;
}
