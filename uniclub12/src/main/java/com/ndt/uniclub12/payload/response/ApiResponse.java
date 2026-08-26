package com.ndt.uniclub12.payload.response;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Setter
@Getter
@SuperBuilder
public class ApiResponse {
    protected Integer code;

    protected String message;

    protected Object data;
}
