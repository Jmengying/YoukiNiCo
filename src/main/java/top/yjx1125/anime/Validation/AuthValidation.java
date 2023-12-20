package top.yjx1125.anime.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import top.yjx1125.anime.anno.Auth;

public class AuthValidation implements ConstraintValidator<Auth,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s==null){
            return false;
        }
        if(s.equals("admin")||s.equals("user"))
        {
            return true;
        }
        return false;
    }
}
