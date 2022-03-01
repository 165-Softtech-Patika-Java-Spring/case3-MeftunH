package com.CommentControlSystem.CommentControlSystem.User.service;

import com.CommentControlSystem.CommentControlSystem.General.enums.StatusType;

import com.CommentControlSystem.CommentControlSystem.User.converter.UserMapper;
import com.CommentControlSystem.CommentControlSystem.User.dto.UserDto;
import com.CommentControlSystem.CommentControlSystem.User.dto.UserSaveRequestDto;
import com.CommentControlSystem.CommentControlSystem.User.entity.User;
import com.CommentControlSystem.CommentControlSystem.User.service.entity.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserEntityService userEntityService;

    public UserDto save(UserSaveRequestDto requestDto) {
        User user = UserMapper.INSTANCE.convertToUser(requestDto);

        user = userEntityService.save(user);

        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);

        return userDto;
    }

}
