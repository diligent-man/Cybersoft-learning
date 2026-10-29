package com.ndt.bookshop_authentication.payload.resp;

import lombok.Getter;
import lombok.Builder;
import lombok.ToString;


@Getter
@Builder
@ToString
public class ApiResp {
    private int status;

    private String message;

    private Object data;
}
