package com.ndt.bookshop_authentication.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class Users {
    @Id
    private String id;

    private String email;

    private String password;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
