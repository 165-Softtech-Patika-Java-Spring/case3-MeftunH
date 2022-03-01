package com.CommentControlSystem.CommentControlSystem.User.dto;

import com.CommentControlSystem.CommentControlSystem.User.enums.UserType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class UserDto {
    private Long id;

    private String name;

    private String surname;

    private String nickname;

    private String email;

    private String phoneNumber;

    private String password;

    private UserType userType;
}
