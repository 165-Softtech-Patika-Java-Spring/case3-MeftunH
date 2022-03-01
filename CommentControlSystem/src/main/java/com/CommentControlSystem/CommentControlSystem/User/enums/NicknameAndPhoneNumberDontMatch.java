package com.CommentControlSystem.CommentControlSystem.User.enums;

import com.CommentControlSystem.CommentControlSystem.General.enums.BaseErrorMessage;

public enum NicknameAndPhoneNumberDontMatch implements BaseErrorMessage {

    USER_NICKNAME_AND_PHONE_NUMBER_DONT_MATCH("USER NICKNAME AND PHONE NUMBER DONT MATCH"),
    ;

    private String message;
    NicknameAndPhoneNumberDontMatch(String message) {
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
