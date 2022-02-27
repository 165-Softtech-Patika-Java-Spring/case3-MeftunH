package com.CommentControlSystem.CommentControlSystem.General.exceptions;

import com.CommentControlSystem.CommentControlSystem.General.enums.BaseErrorMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@Data
public class BusinessException extends RuntimeException {
    private final BaseErrorMessage baseErrorMessage;

}
