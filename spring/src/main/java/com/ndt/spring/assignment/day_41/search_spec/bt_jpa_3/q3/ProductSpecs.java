package com.ndt.spring.assignment.day_41.search_spec.bt_jpa_3.q3;

import org.springframework.data.jpa.domain.Specification;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q3.ProductEntity;


public class ProductSpecs {
    public static Specification<ProductEntity> hasCategoryId(Integer categoryId) {
        return (root, query, cb) -> {
            if (categoryId == null) {
                return null;
            }
            // can be more strongly-type safe with JPA Static Metamodel Generator !
            return cb.equal(root.get("category").get("id"), categoryId);
        };
    }
}
