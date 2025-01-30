package com.example.dto;

import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LogRequest {

    private int n;
    private String timestamp;
    private List<Integer> shuffledNumbers;
}
