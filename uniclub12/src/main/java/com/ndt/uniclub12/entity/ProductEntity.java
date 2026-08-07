package com.ndt.uniclub12.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;


import lombok.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private String information;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private BrandEntity brand;
}
