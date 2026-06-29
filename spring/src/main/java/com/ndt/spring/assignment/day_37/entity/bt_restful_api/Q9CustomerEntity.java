package com.ndt.spring.assignment.day_37.entity.bt_restful_api;

import lombok.*;


@Getter
@ToString
@NoArgsConstructor
public class Q9CustomerEntity {
    private static int autoId = 1;

    private Integer id;

    @Setter
    private String name;

    @Setter
    private String phone;


    public Q9CustomerEntity(String name, String phone) {
        this.name = name;
        this.phone = phone;
        id = autoId++;
    }
}
