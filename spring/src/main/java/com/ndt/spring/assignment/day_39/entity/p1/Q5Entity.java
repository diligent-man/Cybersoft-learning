package com.ndt.spring.assignment.day_39.entity.p1;

import lombok.Data;


@Data
public class Q5Entity implements Cloneable{
    private Integer id;
    private Integer total;


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
