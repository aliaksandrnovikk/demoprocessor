package com.example.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LogRequest {

    private String message;
    private String timestamp;
}
