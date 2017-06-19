package it.uniroma3.siwgalleria.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by jerongeorge on 19/06/17.
 */
public class SizeValidator implements ConstraintValidator<SizeValidation, Double> {

    public void initialize(SizeValidation constraint) {
    }

    public boolean isValid(Double size, ConstraintValidatorContext context) {
        return size>0.0;
    }
}
