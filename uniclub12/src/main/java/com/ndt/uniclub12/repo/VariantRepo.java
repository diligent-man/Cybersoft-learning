package com.ndt.uniclub12.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.uniclub12.entity.VariantEntity;


@Repository
public interface VariantRepo extends JpaRepository<VariantEntity, Integer> {

}
