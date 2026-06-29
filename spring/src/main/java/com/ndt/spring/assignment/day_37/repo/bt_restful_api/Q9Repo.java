package com.ndt.spring.assignment.day_37.repo.bt_restful_api;

import java.util.*;


import jakarta.annotation.PostConstruct;


import org.springframework.stereotype.Service;


import com.ndt.spring.assignment.day_37.entity.bt_restful_api.Q9CustomerEntity;


@Service("btRestfullAPIQ9Repo")
public class Q9Repo {
    // Fake data cuz not have repo
    private final List<Q9CustomerEntity> customers = new ArrayList<>();


    @PostConstruct
    public void init() {
        Q9CustomerEntity customer = new Q9CustomerEntity("Mike", "0931 964 000");
        customers.add(customer);

        customer = new Q9CustomerEntity("Alex", "0931 964 001");
        customers.add(customer);

        customer = new Q9CustomerEntity("Beta", "0931 964 002");
        customers.add(customer);
    }


    public List<Q9CustomerEntity> findAll() {
        return customers;
    }


    public Optional<Q9CustomerEntity> findById(int id) {
        return customers
            .stream()
            .filter(ele -> ele.getId().equals(id))
            .findFirst();
    }
}
