package com.CommentControlSystem.CommentControlSystem.User.controller;

import com.CommentControlSystem.CommentControlSystem.General.dto.RestResponse;
import com.CommentControlSystem.CommentControlSystem.User.dto.UserDto;
import com.CommentControlSystem.CommentControlSystem.User.dto.UserSaveRequestDto;
import com.CommentControlSystem.CommentControlSystem.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }

    @PostMapping
    @Valid
    public ResponseEntity createProduct(@RequestBody UserSaveRequestDto userDTO) {
        UserDto userDto = userService.save(userDTO);
        return ResponseEntity
                .ok(RestResponse.of(userDto));
    }
}
