package com.ndt.spring.assignment.day_37.service.bt_restful_api;

import java.util.*;

import jakarta.annotation.PostConstruct;


import org.springframework.stereotype.Service;


import com.ndt.spring.assignment.day_37.request.bt_restful_api.Q4PutRequest;
import com.ndt.spring.assignment.day_37.entity.bt_restful_api.Q4ProductEntity;


@Service("btRestfullAPIQ4Service")
public class Q4Service {
    // Fake data cuz not have repo
    private final List<Q4ProductEntity> products = new ArrayList<>();


    @PostConstruct
    public void init() {
        Q4ProductEntity product = new Q4ProductEntity(1, "Nike");
        products.add(product);

        product = new Q4ProductEntity(2, "Adidas");
        products.add(product);
    }


    public List<Q4ProductEntity> getProducts() {
        return products;
    }


    public Optional<Q4ProductEntity> getProduct(int id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }


    public boolean addProduct(Q4ProductEntity product) {
        return products.add(product);
    }


    public boolean removeProduct(Q4ProductEntity product) {
        return products.remove(product);
    }


    public boolean removeProduct(int id) {
        Optional<Q4ProductEntity> opQ4ProductEntity = getProduct(id);
        return opQ4ProductEntity.filter(this::removeProduct).isPresent();
    }


    public boolean updateProduct(int id, Q4PutRequest productToUpdate) {
        // Supposing that: all IDs are unique
        Optional<Q4ProductEntity> opQ4Product = products.stream().filter(p -> p.getId().equals(id)).findFirst();

        boolean updateResult = false;
        if (opQ4Product.isPresent()) {
            Q4ProductEntity product = opQ4Product.get();
            product.setName(productToUpdate.getName());
            updateResult = true;
        }

        return updateResult;
    }
}
