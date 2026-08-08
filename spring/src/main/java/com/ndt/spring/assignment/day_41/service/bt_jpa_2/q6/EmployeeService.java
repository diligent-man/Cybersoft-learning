package com.ndt.spring.assignment.day_41.service.bt_jpa_2.q6;

import lombok.RequiredArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q6.EmployeeEntity;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q6.EmployeeRepo;


@Service("btJPA2Q6EmployeeService")
@RequiredArgsConstructor
public class EmployeeService {
    @Qualifier("btJPA2Q6EmployeeRepo")
    private final EmployeeRepo employeeRepo;


    public Page<EmployeeEntity> getAll(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }
}
