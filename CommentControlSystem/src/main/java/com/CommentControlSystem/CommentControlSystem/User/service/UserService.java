package com.CommentControlSystem.CommentControlSystem.User.service;

import com.CommentControlSystem.CommentControlSystem.General.enums.StatusType;

import com.CommentControlSystem.CommentControlSystem.General.exceptions.ItemNotFoundException;
import com.CommentControlSystem.CommentControlSystem.Product.converter.ProductMapper;
import com.CommentControlSystem.CommentControlSystem.Product.dto.ProductDto;
import com.CommentControlSystem.CommentControlSystem.Product.entity.Product;
import com.CommentControlSystem.CommentControlSystem.User.converter.UserMapper;
import com.CommentControlSystem.CommentControlSystem.User.dto.UserDto;
import com.CommentControlSystem.CommentControlSystem.User.dto.UserSaveRequestDto;
import com.CommentControlSystem.CommentControlSystem.User.dto.UserUpdateRequestDto;
import com.CommentControlSystem.CommentControlSystem.User.entity.User;
import com.CommentControlSystem.CommentControlSystem.User.enums.NicknameAndPhoneNumberDontMatch;
import com.CommentControlSystem.CommentControlSystem.User.enums.UserErrorMessage;
import com.CommentControlSystem.CommentControlSystem.User.enums.UserResourceNotFoundException;
import com.CommentControlSystem.CommentControlSystem.User.service.entity.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
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

    public List<UserDto> findAll() {
        List<User> users = userEntityService.findAll();

        return UserMapper.INSTANCE.convertToUserDtoList(users);
    }

    public UserDto findByNickname(String name) {
        User user = userEntityService.findByNickname(name);

        return UserMapper.INSTANCE.convertToUserDto(user);
    }

    public UserDto findById(Long id) {
        User user = userEntityService.getByIdWithControl(id);

        return UserMapper.INSTANCE.convertToUserDto(user);
    }

    public UserDto update(UserUpdateRequestDto userUpdateRequestDto) {

        controlIsUserExist(userUpdateRequestDto);

        User user;
        user = UserMapper.INSTANCE.convertToUser(userUpdateRequestDto);
        userEntityService.save(user);

        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);

        return userDto;
    }

    private void controlIsUserExist(UserUpdateRequestDto userUpdateRequestDto) {

        Long id = userUpdateRequestDto.getId();

        boolean isExist = userEntityService.existsById(id);
        if (!isExist){
            throw new ItemNotFoundException(UserErrorMessage.USER_ERROR_MESSAGE);
        }
    }

    public void delete(String nickname, String phonenumber) {

        try {
            User user = userEntityService.findByNicknameAndPhoneNumber(nickname, phonenumber);

            userEntityService.delete(user);
        } catch (UserResourceNotFoundException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User Not Found", exc);
        }
    }

}
