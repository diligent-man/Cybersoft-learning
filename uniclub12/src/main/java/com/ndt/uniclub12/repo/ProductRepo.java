package com.ndt.uniclub12.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.uniclub12.entity.ProductEntity;


@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

}
