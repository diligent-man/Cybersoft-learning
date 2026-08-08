package com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q8;

import java.util.List;
import java.time.LocalDateTime;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q8.OrderEntity;


@Repository("btJPA2Q8OrderRepo")
public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {
    @Query("""
            SELECT o
            FROM btJPA2Q8Order o
            WHERE o.createdAt BETWEEN :from AND :to
        """)
    List<OrderEntity> findOrdersInDateRange(
        @Param("from") LocalDateTime from,
        @Param("to") LocalDateTime to
    );


    @Query("""
            SELECT o
            FROM btJPA2Q8Order o
            ORDER BY o.totalAmount DESC LIMIT 5
        """)
    List<OrderEntity> findTop5OrdersByTotalAmount();  // Same: List<OrderEntity> findTop5ByOrderByTotalAmountDesc();
}
