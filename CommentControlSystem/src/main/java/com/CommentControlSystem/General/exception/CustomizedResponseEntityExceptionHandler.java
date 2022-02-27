package com.CommentControlSystem.General.exception;

import com.CommentControlSystem.General.dto.RestResponse;
import com.CommentControlSystem.General.exceptions.BusinessException;
import com.CommentControlSystem.General.exceptions.ItemNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class CustomizedResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest){

        Date errorDate = new Date();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse ExceptionResponse = new ExceptionResponse(errorDate, message, description);

        RestResponse<ExceptionResponse> restResponse = RestResponse.error(ExceptionResponse);
        restResponse.setMessages(message);

        return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllItemNotFoundException(ItemNotFoundException ex, WebRequest webRequest){

        Date errorDate = new Date();
        String message = ex.getBaseErrorMessage().getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse ExceptionResponse = new ExceptionResponse(errorDate, message, description);

        RestResponse<ExceptionResponse> restResponse = RestResponse.error(ExceptionResponse);
        restResponse.setMessages(message);

        return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllGenBusinessException(BusinessException ex, WebRequest webRequest){

        Date errorDate = new Date();
        String message = ex.getBaseErrorMessage().getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse ExceptionResponse = new ExceptionResponse(errorDate, message, description);

        RestResponse<ExceptionResponse> restResponse = RestResponse.error(ExceptionResponse);
        restResponse.setMessages(message);

        return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Date errorDate = new Date();
        String message = "Validation failed!";
        String description = ex.getBindingResult().toString();

        ExceptionResponse ExceptionResponse = new ExceptionResponse(errorDate, message, description);
        RestResponse<ExceptionResponse> restResponse = RestResponse.error(ExceptionResponse);
        restResponse.setMessages(message);

        return new ResponseEntity<>(restResponse, HttpStatus.BAD_REQUEST);
    }
}
