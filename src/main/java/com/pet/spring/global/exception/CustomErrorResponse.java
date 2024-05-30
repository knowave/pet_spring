package com.pet.spring.global.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CustomErrorResponse {
    private HttpStatus error;
    private String message;

    public CustomErrorResponse(HttpStatus error, String message) {
        this.error = error;
        this.message = message;
    }
}
