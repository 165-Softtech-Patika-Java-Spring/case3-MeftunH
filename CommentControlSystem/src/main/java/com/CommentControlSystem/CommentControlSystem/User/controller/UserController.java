package com.CommentControlSystem.CommentControlSystem.User.controller;

import com.CommentControlSystem.CommentControlSystem.General.dto.RestResponse;
import com.CommentControlSystem.CommentControlSystem.User.dto.UserDto;
import com.CommentControlSystem.CommentControlSystem.User.dto.UserSaveRequestDto;
import com.CommentControlSystem.CommentControlSystem.User.dto.UserUpdateRequestDto;
import com.CommentControlSystem.CommentControlSystem.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
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
    public ResponseEntity createProduct(@RequestBody @Valid UserSaveRequestDto userDTO) {
        UserDto userDto = userService.save(userDTO);
        return ResponseEntity
                .ok(RestResponse.of(userDto));
    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        List<UserDto> userDto = userService.findAll();
        return ResponseEntity
                .ok(RestResponse.of(userDto));
    }

    @GetMapping("/{username}")
    public ResponseEntity getUserByNickname(@PathVariable String username) {

        UserDto userDto = userService.findByNickname(username);
        return ResponseEntity
                .ok(RestResponse.of(userDto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {

        UserDto userDto = userService.findById(id);
        return ResponseEntity
                .ok(RestResponse.of(userDto));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody UserUpdateRequestDto userDTO) {

        UserDto userDto = userService.update(userDTO);

        return ResponseEntity.ok(RestResponse.of(userDto));
    }

    @DeleteMapping("/{nickname}/{phonenumber}")
    public ResponseEntity delete(@PathVariable String nickname, @PathVariable String phonenumber) {

        userService.delete(nickname, phonenumber);

        return ResponseEntity.ok(RestResponse.empty());
    }
}
