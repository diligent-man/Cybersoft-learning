package com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_2.q9;

import java.util.List;


import lombok.Data;
import lombok.Builder;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_2.q9.CustomerDTO;


@Data
@Builder
public class CustomerResp {
    private List<CustomerDTO> customers;
}
