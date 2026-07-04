package com.ndt.uniclub12.payload.response;

import lombok.Data;


@Data
public class BaseResponse {
    protected String code;

    protected String message;

    protected Object data;
}
