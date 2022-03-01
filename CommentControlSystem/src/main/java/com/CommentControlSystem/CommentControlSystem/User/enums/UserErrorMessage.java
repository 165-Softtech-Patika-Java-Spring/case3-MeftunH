package com.CommentControlSystem.CommentControlSystem.User.enums;

import com.CommentControlSystem.CommentControlSystem.General.enums.BaseErrorMessage;

public enum UserErrorMessage implements BaseErrorMessage {

    USER_ERROR_MESSAGE("User not found!"),
    ;

    private String message;
    UserErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
