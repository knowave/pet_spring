package com.pet.spring.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomErrorResponse> handleCustomException(CustomException exception) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(exception.getStatus(), exception.getMessage());
        return new ResponseEntity<>(errorResponse, exception.getStatus());
    }
}
