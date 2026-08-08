package com.ndt.spring.assignment.day_41.service.bt_jpa_2.q9;

import java.util.List;

import lombok.RequiredArgsConstructor;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_2.q9.CustomerDTO;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q9.CustomerRepo;


@Service("btJPA2Q9CustomerService")
@RequiredArgsConstructor
public class CustomerService {
    @Qualifier("btJPA2Q9CustomerRepo")
    private final CustomerRepo customerRepo;


    public List<CustomerDTO> getAll() {
        return customerRepo
            .findAll()
            .parallelStream()
            .map(CustomerDTO::fromEntity)
            .toList();
    }
}
