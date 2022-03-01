package com.CommentControlSystem.CommentControlSystem.User.annotations;
import com.CommentControlSystem.CommentControlSystem.User.validator.UniqueEmailValidator;
import com.CommentControlSystem.CommentControlSystem.User.validator.UniqueNickNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueNickNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueNickName {
    String message() default "Nickname is already Taken";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
