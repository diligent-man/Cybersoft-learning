package com.ndt.uniclub12.dto;

import java.math.BigDecimal;
import java.util.List;


import lombok.Data;


import com.ndt.uniclub12.entity.VariantEntity;
import com.ndt.uniclub12.entity.ProductEntity;


@Data
public class ProductDTO {
    private Integer id;

    private String name;

    private String desc;

    private String info;

    private BigDecimal price;

    private String image;


    public static ProductDTO fromEntity(ProductEntity entity) {
        ProductDTO obj = new ProductDTO();
        obj.setId(entity.getId());
        obj.setName(entity.getName());
        obj.setDesc(entity.getDescription());
        obj.setInfo(entity.getInformation());
        obj.setPrice(entity.getPrice());

        List<VariantEntity> variants = entity.getVariants();
        if (!variants.isEmpty()) {
            obj.setImage(variants.getFirst().getImages());
        }
        return obj;
    }
}
