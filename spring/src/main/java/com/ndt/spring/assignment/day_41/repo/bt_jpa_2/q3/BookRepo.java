package com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q3;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q3.BookEntity;


@Repository("btJPA2Q3BookRepo")
public interface BookRepo extends JpaRepository<BookEntity, Integer> {

}
