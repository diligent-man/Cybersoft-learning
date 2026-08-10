package com.ndt.spring.assignment.day_41.search_spec.bt_jpa_3.q2;

import org.springframework.data.jpa.domain.Specification;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q2.ProductEntity;


public class ProductSpecs {
    // manually build LIKE op
    public static Specification<ProductEntity> hasNameContainingIgnoreCase(String name) {
        return (root, query, cb) -> {
            if (name == null) {
                return null;
            }
            // equivalent to WHERE LOWER(product.name) LIKE 'LOWER(%<name>%)'
            return cb.like(cb.lower(root.get("name")), String.format("%%%s%%", name.toLowerCase()));
        };
    }
}
