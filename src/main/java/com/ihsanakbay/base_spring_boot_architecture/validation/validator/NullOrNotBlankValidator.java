package com.ihsanakbay.base_spring_boot_architecture.validation.validator;

import com.ihsanakbay.base_spring_boot_architecture.validation.annotation.NullOrNotBlank;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validator implementation for the custom {@link NullOrNotBlank} annotation
 */
public class NullOrNotBlankValidator implements ConstraintValidator<NullOrNotBlank, String> {

    @Override
    public void initialize(NullOrNotBlank constraintAnnotation) {
        // No initialization needed
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Returns true if the value is null or if the trimmed value is not empty
        return value == null || value.trim().length() > 0;
    }
}
