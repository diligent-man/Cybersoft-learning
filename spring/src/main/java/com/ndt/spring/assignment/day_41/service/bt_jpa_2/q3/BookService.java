package com.ndt.spring.assignment.day_41.service.bt_jpa_2.q3;

import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q3.BookEntity;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q3.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("btJPA2Q3BookService")
public class BookService {
    @Qualifier("btJPA2Q3BookRepo")
    private final BookRepo bookRepo;


    public List<BookEntity> getAll() {
        return bookRepo.findAll();
    }
}
