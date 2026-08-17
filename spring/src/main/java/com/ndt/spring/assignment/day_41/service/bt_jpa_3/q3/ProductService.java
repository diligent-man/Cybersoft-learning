package com.ndt.spring.assignment.day_41.service.bt_jpa_3.q3;

import java.util.List;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.repo.bt_jpa_3.q3.*;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q3.*;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_3.q3.*;

import com.ndt.spring.assignment.day_41.dto.bt_jpa_3.q3.ProductDTO;

import com.ndt.spring.assignment.day_41.exception.bt_jpa_3.Q3ErrorMsg;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_3.Q3Exception;
import com.ndt.spring.assignment.day_41.search_spec.bt_jpa_3.q3.ProductSpecs;


@RequiredArgsConstructor
@Service("btJPA3Q3ProductService")
public class ProductService {
    @Qualifier("btJPA3Q3ProductRepo")
    private final ProductRepo productRepo;

    @Qualifier("btJPA3Q3CategoryRepo")
    private final CategoryRepo categoryRepo;


    public List<ProductDTO> getAll() {
        return productRepo
            .findAll()
            .parallelStream()
            .map(ProductDTO::fromEntity)
            .toList();
    }


    public ProductDTO getById(Integer id) {
        return ProductDTO.fromEntity(
            productRepo
                .findById(id)
                .orElseThrow(() -> new Q3Exception(Q3ErrorMsg.PRODUCT_NOT_FOUND))
        );
    }


    public ProductDTO save(AddProductReq req) {
        if (productRepo.existsByName(req.getName())) {
            throw new Q3Exception(Q3ErrorMsg.PRODUCT_EXISTED, "Name '" + req.getName() + "' has been already existed");
        }

        CategoryEntity category = categoryRepo.findById(req.getCategoryId())
            .orElseThrow(() -> new Q3Exception(Q3ErrorMsg.CATEGORY_NOT_FOUND, "Category '" + req.getName() + "' is not found"));


        ProductEntity product = req.toEntity();
        product.setCategory(category);
        return ProductDTO.fromEntity(productRepo.save(product));
    }


    public ProductDTO update(Integer id, UpdateProductReq req) {
        ProductEntity product = productRepo.findById(id)
            .orElseThrow(() -> new Q3Exception(Q3ErrorMsg.PRODUCT_NOT_FOUND, "Product '" + req.getName() + "' is already existed"));

        CategoryEntity category = categoryRepo.findById(req.getCategoryId())
            .orElseThrow(() -> new Q3Exception(Q3ErrorMsg.CATEGORY_NOT_FOUND, "Category '" + req.getName() + "' is not found"));


        product.setName(req.getName());
        product.setPrice(req.getPrice());
        product.setCategory(category);
        return ProductDTO.fromEntity(productRepo.save(product));
    }


    public ProductDTO delete(Integer id) {
        ProductEntity product = productRepo
            .findById(id)
            .orElseThrow(() -> new Q3Exception(Q3ErrorMsg.PRODUCT_NOT_FOUND, "Id " + id + " doesn't exist"));
        productRepo.delete(product);
        return ProductDTO.fromEntity(product);
    }


    public List<ProductDTO> searchProducts(Integer categoryId, Pageable pageable) {
        Specification<ProductEntity> specs = Specification.where(ProductSpecs.hasCategoryId(categoryId));
        return productRepo
            .findAll(specs, pageable)
            .map(ProductDTO::fromEntity)
            .toList();
    }
}
