package com.CommentControlSystem.CommentControlSystem.User.validator;
import com.CommentControlSystem.CommentControlSystem.User.annotations.UniqueEmail;
import com.CommentControlSystem.CommentControlSystem.User.annotations.UniqueNickName;
import com.CommentControlSystem.CommentControlSystem.User.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueNickNameValidator implements ConstraintValidator<UniqueNickName, String>{
    @Autowired
    UserDao userRepository;

    @Override
    public boolean isValid(String nickname, ConstraintValidatorContext context) {
        return userRepository.findByNickname(nickname) == null;
    }
}
