package com.ndt.spring.assignment.day_37.service.bt_restful_api;

import java.util.List;
import java.util.ArrayList;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import com.ndt.spring.assignment.day_37.entity.bt_restful_api.Q4ProductEntity;


@Service("btRestfullAPIQ4Service")
public class Q4Service {
    // Fake data cuz not have repo
    private final List<Q4ProductEntity> products = new ArrayList<>();


    @PostConstruct
    public void init() {
        Q4ProductEntity a = new Q4ProductEntity(1, "Nike");
        products.add(a);

        a = new Q4ProductEntity(2, "Addidas");
        products.add(a);
    }


    public List<Q4ProductEntity> getProducts() {
        return products;
    }


    public Q4ProductEntity getProduct(int id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }


    public boolean addProduct(Q4ProductEntity product) {
        return products.add(product);
    }


    public boolean removeProduct(Q4ProductEntity product) {
        return products.remove(product);
    }


    public boolean removeProduct(int id) {
        return products.remove(getProduct(id));
    }


    public boolean updateProduct(Q4ProductEntity updatedProduct) {
        Integer matchedIdx = null;

        for (Q4ProductEntity product : products) {
            if (product.getId().equals(updatedProduct.getId())) {
                matchedIdx = products.indexOf(product);
                break;
            }
        }

        if (matchedIdx != null) {
            products.set(matchedIdx, updatedProduct);
        }

        return matchedIdx != null;
    }
}
