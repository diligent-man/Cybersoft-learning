package com.ndt.uniclub12.exception;

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveFileException extends RuntimeException {
    public String message;
}
