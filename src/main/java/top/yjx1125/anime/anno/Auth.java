package top.yjx1125.anime.anno;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotEmpty;
import top.yjx1125.anime.Validation.AuthValidation;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({ FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {AuthValidation.class})

public @interface Auth {
    String message() default "{jakarta.validation.constraints.NotEmpty.message}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
