package com.ndt.spring.assignment.day_41.service.bt_jpa_2.q2;

import java.util.List;


import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q2.UpdateProductReq;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q2.ProductRepo;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q2.ProductEntity;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q2.AddProductReq;

import com.ndt.spring.exception.GenericErrorMsg;
import com.ndt.spring.exception.GenericException;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_2.Q2ErrorMsg;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_2.Q2Exception;


@RequiredArgsConstructor
@Service("btJPA2Q2ProductService")
public class ProductService {
    @Qualifier("btJPA2Q2ProductRepo")
    private final ProductRepo productRepo;


    public List<ProductEntity> getAll() {
        return productRepo.findAll();
    }


    public ProductEntity getById(Integer id) {
        return productRepo.findById(id).orElseThrow(() -> new Q2Exception(Q2ErrorMsg.PRODUCT_NOT_FOUND));
    }


    public ProductEntity save(AddProductReq req) {
        if (productRepo.existsByName(req.getName())) {
            throw new GenericException(GenericErrorMsg.CONFLICT, req.getName() + "' is already existed");
        }
        return productRepo.save(req.toEntity());
    }


    public ProductEntity updateProduct(Integer id, UpdateProductReq req) {
        ProductEntity product = getById(id);

        product.setName(req.getName());
        product.setPrice(req.getPrice());
        product.setDescription(req.getDescription());

        return productRepo.save(product);
    }


    public ProductEntity delete(Integer id) {
        ProductEntity product = getById(id);
        productRepo.delete(product);
        return product;
    }
}
