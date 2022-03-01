package com.CommentControlSystem.CommentControlSystem.General.handlers;

import com.CommentControlSystem.CommentControlSystem.Comment.exception.UserHasNotCommentException;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(UserHasNotCommentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Object processValidationError(UserHasNotCommentException ex) {
        String result = ex.getErrorMessage();
        System.out.println("###########"+result);
        return ex;
    }
}
