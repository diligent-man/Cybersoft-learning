package com.ndt.uniclub12.annotation;

import java.lang.annotation.*;


import jakarta.validation.Payload;
import jakarta.validation.Constraint;


import com.ndt.uniclub12.validation.FileValidator;


@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FileValidator.class)
public @interface ValidFile {
    String message() default "Invalid file uploaded";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};


    long maxSize() default 5242880; // Default: 5MB


    String[] allowedTypes() default {"image/jpeg", "image/png", "application/pdf"};
}
