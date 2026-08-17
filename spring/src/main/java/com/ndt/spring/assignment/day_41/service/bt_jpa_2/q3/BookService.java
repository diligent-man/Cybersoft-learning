package com.ndt.spring.assignment.day_41.service.bt_jpa_2.q3;

import java.util.List;
import java.math.BigDecimal;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q3.BookRepo;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q3.BookEntity;
import com.ndt.spring.assignment.day_41.search_spec.bt_jpa_2.q3.BookSpecs;


@RequiredArgsConstructor
@Service("btJPA2Q3BookService")
public class BookService {
    @Qualifier("btJPA2Q3BookRepo")
    private final BookRepo bookRepo;


    public List<BookEntity> getAll() {
        return bookRepo.findAll();
    }


    public List<BookEntity> search(String author, BigDecimal minPrice, BigDecimal maxPrice) {
        Specification<BookEntity> spec = Specification
            .where(BookSpecs.hasAuthor(author))
            .and(BookSpecs.priceGreaterThanOrEqual(minPrice))
            .and(BookSpecs.priceLessThanOrEqual(maxPrice));
        return bookRepo.findAll(spec);
    }
}
