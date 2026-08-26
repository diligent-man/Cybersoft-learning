package com.ndt.uniclub12.payload.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;


import lombok.Data;


import org.springframework.web.multipart.MultipartFile;


import com.ndt.uniclub12.annotation.ValidFile;


@Data
public class InsertProductRequest {
    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Size(max = 65535)
    private String description;

    @NotBlank
    @Size(max = 65535)
    private String information;

    @Positive
    @Digits(integer = 36, fraction = 2)
    private BigDecimal price;

    @Positive
    private Integer idColor;

    @Positive
    private Integer idSize;

    @ValidFile(maxSize = 2097152, allowedTypes = {"image/jpeg", "image/png"}) // 2MB limit
    private MultipartFile file;

    @Positive
    private Integer quantity;

    @Positive
    @Digits(integer = 36, fraction = 2)
    private BigDecimal variantPrice;
}
