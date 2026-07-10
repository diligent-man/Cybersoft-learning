package com.ndt.spring.payload.resp;


import lombok.*;
import lombok.experimental.SuperBuilder;


@Setter
@Getter
@SuperBuilder
public class BaseResp {
    protected Integer code;

    protected String status;

    protected Object data;
}
