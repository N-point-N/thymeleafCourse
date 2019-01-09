package com.study.thymeleaf.Validate;


import com.study.thymeleaf.Model.UserModel;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserModelValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserModel.class.equals(aClass);
    }

    @Override
    public void validate(Object user, Errors errors) {
        UserModel userModel = (UserModel)user;
        if (!userModel.getPassword().equals(userModel.getRepeatPassword())) {
            errors.rejectValue("repeatPassword", "PasswordsDontMatch");
        }
    }
}
