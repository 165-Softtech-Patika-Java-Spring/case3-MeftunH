package com.CommentControlSystem.General.exceptions;

import com.CommentControlSystem.General.enums.BaseErrorMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@RequiredArgsConstructor
@Data
public class BusinessException extends RuntimeException {
    private final BaseErrorMessage baseErrorMessage;

}
