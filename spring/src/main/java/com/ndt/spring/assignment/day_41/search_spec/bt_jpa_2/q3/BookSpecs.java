package com.ndt.spring.assignment.day_41.search_spec.bt_jpa_2.q3;

import java.math.BigDecimal;


import org.springframework.data.jpa.domain.Specification;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q3.BookEntity;


public class BookSpecs {
    public static Specification<BookEntity> hasAuthor(String author) {
        return (root, query, cb) -> author == null ? null : cb.equal(root.get("author"), author);
    }


    public static Specification<BookEntity> priceGreaterThanOrEqual(BigDecimal minPrice) {
        return (root, query, cb) -> minPrice == null ? null : cb.greaterThanOrEqualTo(root.get("price"), minPrice);
    }


    public static Specification<BookEntity> priceLessThanOrEqual(BigDecimal maxPrice) {
        return (root, query, cb) -> maxPrice == null ? null : cb.lessThanOrEqualTo(root.get("price"), maxPrice);
    }
}
