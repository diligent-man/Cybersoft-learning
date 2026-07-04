package com.ndt.uniclub12.enumeric;

import lombok.Getter;
import lombok.AllArgsConstructor;


@Getter
@AllArgsConstructor
public enum AuthenError {
    A00("Login success"),
    A01("Login fail");

    private String message;
}
