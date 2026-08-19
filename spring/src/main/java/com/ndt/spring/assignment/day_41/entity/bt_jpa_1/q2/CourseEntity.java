package com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q2;

import jakarta.persistence.*;

import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@ToString
@Table(name = "course")
@Entity(name = "btJPA1Q2Course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(nullable = false, comment = "thời lượng khóa học, tính theo giờ")
    private BigDecimal duration;
}
