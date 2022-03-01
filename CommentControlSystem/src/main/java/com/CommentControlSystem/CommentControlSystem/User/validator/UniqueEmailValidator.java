package com.CommentControlSystem.CommentControlSystem.User.validator;
import com.CommentControlSystem.CommentControlSystem.User.annotations.UniqueEmail;
import com.CommentControlSystem.CommentControlSystem.User.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    UserDao userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return userRepository.findByEmail(email) == null;
    }
}
