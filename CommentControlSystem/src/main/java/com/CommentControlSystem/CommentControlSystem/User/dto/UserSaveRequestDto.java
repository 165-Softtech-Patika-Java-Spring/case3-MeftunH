package com.CommentControlSystem.CommentControlSystem.User.dto;

import com.CommentControlSystem.CommentControlSystem.User.annotations.UniqueEmail;
import com.CommentControlSystem.CommentControlSystem.User.annotations.UniqueNickName;
import com.CommentControlSystem.CommentControlSystem.User.annotations.UniquePhone;
import com.CommentControlSystem.CommentControlSystem.User.enums.UserType;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
public class UserSaveRequestDto {

    private String name;

    private String surname;

    @Valid
    @Email(message = "Email is not valid")
    @UniqueEmail
    private String email;

    @Valid
    @UniqueNickName
    private String nickname;

    @Valid
    @UniquePhone
    @Pattern(regexp="^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$", message = "Phone number not valid")
    private String phoneNumber;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
