package com.ndt.spring.assignment.day_41.service.bt_jpa_2.q4;

import java.util.List;


import com.ndt.spring.assignment.day_41.exception.bt_jpa_2.Q4ErrorMsg;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_2.Q4Exception;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q4.AddProductReq;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.exception.GenericErrorMsg;
import com.ndt.spring.exception.GenericException;

import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q4.AddCategoryReq;

import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q4.ProductRepo;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q4.CategoryRepo;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q4.ProductEntity;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q4.CategoryEntity;


@RequiredArgsConstructor
@Service("btJPA2Q4CategoryService")
public class CategoryService {
    @Qualifier("btJPA2Q4CategoryRepo")
    private final CategoryRepo categoryRepo;

    @Qualifier("btJPA2Q4ProductRepo")
    private final ProductRepo productRepo;


    public List<ProductEntity> getProductsByCategory(Integer id) {
        return productRepo.findByCategoryId(id);
    }


    public CategoryEntity addCategory(AddCategoryReq req) {
        if (categoryRepo.existsByName(req.getName())) {
            throw new GenericException(
                GenericErrorMsg.CONFLICT,
                String.format("Category [%s] existed", req.getName())
            );
        }
        return categoryRepo.save(req.toEntity());
    }
}
