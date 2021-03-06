package com.CommentControlSystem.CommentControlSystem.Comment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CommentControllerAdvice {
    @ExceptionHandler(UserHasNotCommentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public UserHasNotCommentResponse handleUserHasNotCommentException(UserHasNotCommentException se) {
        UserHasNotCommentResponse response = new UserHasNotCommentResponse(se.getMessage());
        return response;
    }

    @ExceptionHandler(ProductHasNotCommentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ProductHasNotCommentResponse handleProductHasNotCommentException(ProductHasNotCommentException se) {
        ProductHasNotCommentResponse response = new ProductHasNotCommentResponse(se.getMessage());
        return response;
    }
}
