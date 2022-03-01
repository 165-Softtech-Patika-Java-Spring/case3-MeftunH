package com.CommentControlSystem.CommentControlSystem.User.dto;

import com.CommentControlSystem.CommentControlSystem.User.enums.UserType;
import lombok.Data;

@Data
public class UserUpdateRequestDto {
    private Long id;

    private String name;

    private String surname;

    private String nickname;

    private String email;

    private String phoneNumber;

    private String password;

    private UserType userType;
}
