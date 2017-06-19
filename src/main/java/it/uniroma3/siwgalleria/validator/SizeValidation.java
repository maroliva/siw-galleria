package it.uniroma3.siwgalleria.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by jerongeorge on 19/06/17.
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SizeValidator.class)
public @interface SizeValidation {
    String message() default "Inserire un valore maggiore di 0";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
