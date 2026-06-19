package com.ndt.spring.assignment.day_39.entity.p1;

import lombok.Data;


@Data
public class Q4Entity implements Cloneable {
    private Integer id;

    private String name;


    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            Q4Entity obj = new Q4Entity();

            obj.setId(this.getId());
            obj.setName(this.getName());
            return obj;
        }

    }
}
