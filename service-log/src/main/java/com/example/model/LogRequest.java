package com.example.model;

import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LogRequest {

    private int number;
    private String timestamp;
    private List<Integer> shuffledNumbers;
}
