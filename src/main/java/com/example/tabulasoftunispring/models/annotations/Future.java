package com.example.tabulasoftunispring.models.annotations;

import com.example.tabulasoftunispring.models.validators.FutureValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FutureValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Future {

    String message() default "The date should be in the future.";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
