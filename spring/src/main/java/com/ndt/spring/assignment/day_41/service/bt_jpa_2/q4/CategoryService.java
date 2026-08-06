package com.ndt.spring.assignment.day_41.service.bt_jpa_2.q4;

import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q4.CategoryEntity;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q4.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("btJPA2Q4CategoryService")
public class CategoryService {
    @Qualifier("btJPA2Q4CategoryRepo")
    private final CategoryRepo categoryRepo;


    public List<CategoryEntity> getAll() {
        return categoryRepo.findAll();
    }
}
