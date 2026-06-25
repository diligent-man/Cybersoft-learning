package com.ndt.spring.assignment.day_37.entity.bt_restful_api;

import java.util.ArrayList;
import java.util.List;


import lombok.*;


@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Q7AuthorEntity {
    private Integer id;

    @Setter
    private String name;

    private final List<Q7BookEntity> bookLst = new ArrayList<>();
}
