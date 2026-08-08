package com.ndt.spring.assignment.day_41.service.bt_jpa_2.q4;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q4.ProductEntity;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q4.CategoryEntity;

import com.ndt.spring.assignment.day_41.exception.bt_jpa_2.Q4ErrorMsg;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_2.Q4Exception;

import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q4.ProductRepo;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q4.CategoryRepo;


import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q4.AddProductReq;


@RequiredArgsConstructor
@Service("btJPA2Q4ProductService")
public class ProductService {
    @Qualifier("btJPA2Q4ProductRepo")
    private final ProductRepo productRepo;

    @Qualifier("btJPA2Q4CategoryRepo")
    private final CategoryRepo categoryRepo;


    public ProductEntity addProduct(Integer categoryId, AddProductReq req) {
        CategoryEntity category = categoryRepo
            .findById(categoryId)
            .orElseThrow(() -> new Q4Exception(Q4ErrorMsg.CATEGORY_NOT_FOUND, String.format("Category [%s] not found with : ", categoryId)));

        ProductEntity product = new ProductEntity();

        product.setName(req.getName());
        product.setPrice(req.getPrice());
        product.setCategory(category);

        return productRepo.save(product);
    }
}
