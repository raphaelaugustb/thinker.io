package com.leah.thinker.io.handler;

import com.leah.thinker.io.exception.IdeaNotFoundException;
import com.leah.thinker.io.model.ErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class IdeaExceptionHandler  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IdeaNotFoundException.class)
    public ResponseEntity<ErrorHandler> handleUserNotFoundException(IdeaNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorHandler(HttpStatus.NOT_FOUND, e.getMessage(), HttpStatus.NOT_FOUND.value()));
    }
}
