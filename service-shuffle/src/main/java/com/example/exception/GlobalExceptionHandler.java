package com.example.exception;

import static org.springframework.http.MediaType.APPLICATION_PROBLEM_JSON;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Problem> handleAllExceptions(Exception ex) {
        log.error("Unhandled RuntimeException occurred.", ex);
        Problem problem = new Problem("unhandled exception occurred");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(APPLICATION_PROBLEM_JSON)
                .body(problem);
    }

    public record Problem(String details) {

    }
}
