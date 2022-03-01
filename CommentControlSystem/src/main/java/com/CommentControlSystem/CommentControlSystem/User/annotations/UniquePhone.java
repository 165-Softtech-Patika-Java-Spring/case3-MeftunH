package com.CommentControlSystem.CommentControlSystem.User.annotations;

import com.CommentControlSystem.CommentControlSystem.User.validator.UniqueNickNameValidator;
import com.CommentControlSystem.CommentControlSystem.User.validator.UniquePhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniquePhoneValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniquePhone {
    String message() default "Phone Number is already Taken";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
