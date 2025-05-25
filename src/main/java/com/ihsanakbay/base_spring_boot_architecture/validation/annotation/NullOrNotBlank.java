package com.ihsanakbay.base_spring_boot_architecture.validation.annotation;

import com.ihsanakbay.base_spring_boot_architecture.validation.validator.NullOrNotBlankValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Custom validation annotation that validates a String field is either null or not blank
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NullOrNotBlankValidator.class)
public @interface NullOrNotBlank {
    String message() default "Field must be either null or not blank";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
