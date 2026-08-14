package com.ndt.uniclub12.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;


import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@Entity(name = "variant")
public class VariantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sku;

    private String image;

    private Integer quantity;

    private BigDecimal price;

    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "id_color")
    private ColorEntity color;


    @ManyToOne
    @JoinColumn(name = "id_size")
    private SizeEntity size;
}
