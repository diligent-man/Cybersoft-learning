package com.ndt.spring.assignment.day_41.service.bt_jpa_1.q2;

import java.math.BigDecimal;
import java.util.List;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q2.CourseRepo;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q2.CourseEntity;


@RequiredArgsConstructor
@Service("btJPA1Q2CourseService")
public class CourseService {
    @Qualifier("btJPA1Q2CourseRepo")
    private final CourseRepo userRepo;


    public List<CourseEntity> getAll() {
        return userRepo.findAll();
    }

    public List<CourseEntity> search(BigDecimal durationGreaterThan) {
        return userRepo.findByDurationGreaterThan(durationGreaterThan);
    }
}
