package com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q2;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "usersss")
public class UserEntity {
    @Id
    private String id;

    private String email;

    private String password;
}
