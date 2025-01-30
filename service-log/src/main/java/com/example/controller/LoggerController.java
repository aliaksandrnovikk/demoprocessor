package com.example.controller;

import com.example.dto.LogRequest;
import com.example.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoggerController {

    private LoggingService loggingService;

    @Autowired
    public LoggerController(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @PostMapping("/log")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logRequest(@RequestBody LogRequest logRequest) {
        loggingService.log(logRequest);
    }
}
