package pl.kobietydokodu.dto;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = WeightValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotZeroWeight {
    String message() default "Waga musi być większa od zero";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
