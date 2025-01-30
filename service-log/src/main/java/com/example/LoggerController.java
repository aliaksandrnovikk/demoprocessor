package com.example;

import com.example.model.LogRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoggerController {

    @PostMapping("/log")
    public Object logRequest(@RequestBody LogRequest logRequest) {
        System.out.println("Logging Request: Number - " + logRequest.getNumber() +
                ", Shuffled Numbers - " + logRequest.getShuffledNumbers());
        return "Data logged successfully: " + logRequest;
    }
}
