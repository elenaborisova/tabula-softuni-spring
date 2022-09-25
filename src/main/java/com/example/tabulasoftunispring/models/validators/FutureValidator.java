package com.example.tabulasoftunispring.models.validators;

import com.example.tabulasoftunispring.models.annotations.Future;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class FutureValidator implements ConstraintValidator<Future, LocalDateTime> {
    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
        return value != null && value.isAfter(LocalDateTime.now());
    }
}
