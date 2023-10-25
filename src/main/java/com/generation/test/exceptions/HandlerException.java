package com.generation.test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerException {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(NotFoundException e) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Not Found")
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }
}