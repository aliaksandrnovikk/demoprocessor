package com.example.service;

import com.example.dto.LogRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsoleLoggingServiceImpl implements LoggingService {

    @Override
    public void log(LogRequest logRequest) {
        logRequest.setTimestamp(String.valueOf(System.currentTimeMillis()));
        System.out.println(logRequest.toString());
    }
}
