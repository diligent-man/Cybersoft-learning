package com.ndt.spring.assignment.day_41.service.bt_jpa_2.q8;

import java.util.List;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q8.OrderEntity;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q8.OrderRepo;


@Service("btJPA2Q8OrderService")
@RequiredArgsConstructor
public class OrderService {
    @Qualifier("btJPA2Q8OrderRepo")
    private final OrderRepo orderRepo;


    public List<OrderEntity> findTop5OrdersByTotalAmount() {
        return orderRepo.findTop5OrdersByTotalAmount();
    }
}
