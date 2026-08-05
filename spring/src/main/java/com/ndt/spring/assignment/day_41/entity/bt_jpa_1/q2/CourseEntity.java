package com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q2;

import jakarta.persistence.*;

import lombok.*;


@Getter
@Setter
@ToString
@Entity(name = "course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(nullable = false, comment = "thời lượng khóa học, tính theo giờ")
    private Integer duration;
}
