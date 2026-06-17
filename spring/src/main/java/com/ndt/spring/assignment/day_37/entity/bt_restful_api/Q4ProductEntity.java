package com.ndt.spring.assignment.day_37.entity.bt_restful_api;

import jakarta.persistence.*;

import lombok.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Q4ProductEntity {
    private Integer id;

    @Setter
    private String name;
}
