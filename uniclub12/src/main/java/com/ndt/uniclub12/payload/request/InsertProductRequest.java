package com.ndt.uniclub12.payload.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;


@Data
public class InsertProductRequest {
    private String name;

    private String description;

    private BigDecimal price;

    private Integer idColor;

    private Integer idSize;

    private MultipartFile file;

    private Integer quantity;

    private BigDecimal variantPrice;
}
