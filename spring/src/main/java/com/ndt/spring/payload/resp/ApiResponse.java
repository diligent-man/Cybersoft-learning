package com.ndt.spring.payload.resp;


import lombok.*;
import lombok.experimental.SuperBuilder;


@Setter
@Getter
@SuperBuilder
public class ApiResponse {
    protected String code;

    protected String status;

    protected Object data;
}
