package com.ndt.uniclub12.entity;

import jakarta.persistence.*;

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@Entity(name = "color")
public class ColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
