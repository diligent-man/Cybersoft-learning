package com.ndt.uniclub12.exception;

import lombok.*;


import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public enum FileErrorMsg implements ErrorMsg {
    FILE_EXISTED(HttpStatus.CONFLICT, "A file of that name already exists."),
    FILE_UPLOADED(HttpStatus.OK, "Upload successfully."),
    FILE_UPLOAD_FAILED(HttpStatus.EXPECTATION_FAILED, "Upload failed."),
    ;

    private final HttpStatus httpStatus;

    @ToString.Include
    private final String errorMsg;
}
