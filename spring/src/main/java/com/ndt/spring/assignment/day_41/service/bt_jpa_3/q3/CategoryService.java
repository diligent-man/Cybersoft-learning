package com.ndt.spring.assignment.day_41.service.bt_jpa_3.q3;

import java.util.List;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_3.q3.CategoryDTO;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_3.q3.CategoryRepo;

import com.ndt.spring.assignment.day_41.exception.bt_jpa_3.Q3ErrorMsg;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_3.Q3Exception;


@RequiredArgsConstructor
@Service("btJPA3Q3CategoryService")
public class CategoryService {
    @Qualifier("btJPA3Q3CategoryRepo")
    private final CategoryRepo categoryRepo;


    public List<CategoryDTO> getAll() {
        return categoryRepo
            .findAll()
            .parallelStream()
            .map(CategoryDTO::fromEntity)
            .toList();
    }


    public CategoryDTO getById(Integer id) {
        return CategoryDTO.fromEntity(
            categoryRepo
                .findById(id)
                .orElseThrow(() -> new Q3Exception(Q3ErrorMsg.PRODUCT_NOT_FOUND))
        );
    }
}
