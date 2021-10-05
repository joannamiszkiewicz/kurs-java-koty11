package pl.kobietydokodu.dto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WeightValidator implements ConstraintValidator<NotZeroWeight, Float> {
    @Override
    public void initialize(NotZeroWeight notZeroWeight) {
    }

    @Override
    public boolean isValid(Float weightField, ConstraintValidatorContext cxt) {
        return weightField != null && weightField.compareTo(0.0f) > 0;
    }
}
