package com.CommentControlSystem.CommentControlSystem.User.validator;

import com.CommentControlSystem.CommentControlSystem.User.annotations.UniqueNickName;
import com.CommentControlSystem.CommentControlSystem.User.annotations.UniquePhone;
import com.CommentControlSystem.CommentControlSystem.User.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniquePhoneValidator implements ConstraintValidator<UniquePhone, String> {
    @Autowired
    UserDao userRepository;

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        return userRepository.findByPhoneNumber(phoneNumber) == null;
    }
}
