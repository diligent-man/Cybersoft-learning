package com.ndt.spring.assignment.day_41.service.bt_jpa_2.q2;

import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q2.ProductEntity;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q2.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("btJPA2Q2ProductService")
public class ProductService {
    @Qualifier("btJPA2Q2ProductRepo")
    private final ProductRepo productRepo;


    public List<ProductEntity> getAll() {
        return productRepo.findAll();
    }
}
