package com.ndt.spring.assignment.day_41.dto.bt_jpa_2.q9;

import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q9.CustomerEntity;
import lombok.Data;


@Data
public class CustomerDTO {
    private Integer id;

    private String name;

    private String phone;


    public static CustomerDTO fromEntity(CustomerEntity entity) {
        CustomerDTO obj = new CustomerDTO();
        obj.setId(entity.getId());
        obj.setName(entity.getName());
        obj.setPhone(entity.getPhone());
        return obj;
    }
}
