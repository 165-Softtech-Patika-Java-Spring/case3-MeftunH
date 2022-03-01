package com.CommentControlSystem.CommentControlSystem.User.enums;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserResourceNotFoundException extends RuntimeException {
    public UserResourceNotFoundException() {
        super();
    }
    public UserResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public UserResourceNotFoundException(String message) {
        super(message);
    }
    public UserResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}