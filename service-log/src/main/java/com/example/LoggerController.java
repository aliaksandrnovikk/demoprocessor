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
    public String logRequest(@RequestBody LogRequest logRequest) {
        System.out.println("Logged Data: " + logRequest.toString());
        return "Data logged successfully: " + logRequest;
    }
}
