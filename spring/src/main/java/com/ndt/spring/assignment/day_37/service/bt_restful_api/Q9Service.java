package com.ndt.spring.assignment.day_37.service.bt_restful_api;

import java.util.List;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;


import com.ndt.spring.assignment.day_37.repo.bt_restful_api.Q9Repo;
import com.ndt.spring.assignment.day_37.entity.bt_restful_api.Q9CustomerEntity;


import com.ndt.spring.assignment.day_37.exceptions.bt_restful_api.Q9ErrorMsg;
import com.ndt.spring.assignment.day_37.exceptions.bt_restful_api.Q9Exception;


@RequiredArgsConstructor
@Service("btRestfullAPIQ9Service")
public class Q9Service {
    private final Q9Repo q9Repo;


    public List<Q9CustomerEntity> getCustomers() {
        return q9Repo.findAll();
    }


    public Q9CustomerEntity getCustomer(int id) {
        return q9Repo.findById(id).orElseThrow(() -> new Q9Exception(Q9ErrorMsg.CUSTOMER_NOT_FOUND));
    }

    //
    // public boolean addProduct(Q4ProductEntity product) {
    //     // data validation is on repo not here !
    //     return products.add(product);
    // }
    //
    //
    // public boolean removeProduct(Q4ProductEntity product) {
    //     return products.remove(product);
    // }
    //
    //
    // public boolean removeProduct(int id) {
    //     Optional<Q4ProductEntity> opQ4ProductEntity = getProduct(id);
    //     return opQ4ProductEntity.filter(this::removeProduct).isPresent();
    // }
    //
    //
    // public boolean updateProduct(int id, Q4PutRequest productToUpdate) {
    //     // Supposing that: all IDs are unique
    //     Optional<Q4ProductEntity> opQ4Product = products.stream().filter(p -> p.getId().equals(id)).findFirst();
    //
    //     boolean updateResult = false;
    //     if (opQ4Product.isPresent()) {
    //         Q4ProductEntity product = opQ4Product.get();
    //         product.setName(productToUpdate.getName());
    //         updateResult = true;
    //     }
    //
    //     return updateResult;
    // }
}
