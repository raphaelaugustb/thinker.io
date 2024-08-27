package com.leah.thinker.io.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class ErrorHandler {
    private HttpStatus httpStatus;
    private String message;
    private int code;
}
