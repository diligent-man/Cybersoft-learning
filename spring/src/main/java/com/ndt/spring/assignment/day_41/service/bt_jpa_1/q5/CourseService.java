package com.ndt.spring.assignment.day_41.service.bt_jpa_1.q5;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_1.q5.CourseDTO;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q5.CourseRepo;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q5.CourseEntity;


@Service("btJPA1Q5CourseService")
@RequiredArgsConstructor
public class CourseService {
    @Qualifier("btJPA1Q5CourseRepo")
    private final CourseRepo courseRepo;


    public Page<CourseDTO> getAll(Pageable pageable) {
        return courseRepo
            .findAll(pageable)
            .map(this::toCourseDto);
    }


    private CourseDTO toCourseDto(CourseEntity obj) {
        return CourseDTO.fromEntity(obj);
    }
}
