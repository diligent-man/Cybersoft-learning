package com.ndt.spring.assignment.day_41.service.bt_jpa_3.q2;

import java.util.List;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_3.q2.ProductDTO;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_3.q2.ProductRepo;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q2.ProductEntity;
import com.ndt.spring.assignment.day_41.search_spec.bt_jpa_3.q2.ProductSpecs;

import com.ndt.spring.assignment.day_41.exception.bt_jpa_3.Q2ErrorMsg;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_3.Q2Exception;

import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_3.q2.AddProductReq;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_3.q2.UpdateProductReq;


@RequiredArgsConstructor
@Service("btJPA3Q2ProductService")
public class ProductService {
    @Qualifier("btJPA3Q2ProductRepo")
    private final ProductRepo productRepo;


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
                .orElseThrow(() -> new Q2Exception(Q2ErrorMsg.NOT_FOUND))
        );
    }


    public ProductDTO save(AddProductReq req) {
        if (productRepo.existsByName(req.getName())) {
            throw new Q2Exception(Q2ErrorMsg.EXISTED, "Name '" + req.getName() + "' has been already existed");
        }
        return ProductDTO.fromEntity(productRepo.save(req.toEntity()));
    }


    public ProductDTO update(Integer id, UpdateProductReq req) {
        ProductEntity product = productRepo.findById(id)
            .orElseThrow(() -> new Q2Exception(Q2ErrorMsg.NOT_FOUND, "Product '" + req.getName() + "' is already registered"));

        product.setName(req.getName());
        product.setPrice(req.getPrice());
        product.setDescription(req.getDescription());
        return ProductDTO.fromEntity(productRepo.save(product));
    }


    public ProductDTO delete(Integer id) {
        ProductEntity product = productRepo
            .findById(id)
            .orElseThrow(() -> new Q2Exception(Q2ErrorMsg.NOT_FOUND, "Id " + id + " doesn't exist"));
        productRepo.delete(product);
        return ProductDTO.fromEntity(product);
    }


    public List<ProductDTO> searchProducts(String name, Pageable pageable) {
        Specification<ProductEntity> specs = Specification.where(ProductSpecs.hasNameContainingIgnoreCase(name));
        return productRepo
            .findAll(specs, pageable)
            .map(ProductDTO::fromEntity)
            .toList();
    }
}
