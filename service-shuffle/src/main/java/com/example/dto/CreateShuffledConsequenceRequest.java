package com.example.dto;

import java.util.List;
import lombok.Data;

@Data
public class CreateShuffledConsequenceRequest {
    private int n;
    private List<Integer> shuffledNumbers;
}
