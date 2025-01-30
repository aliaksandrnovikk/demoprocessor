package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@AllArgsConstructor
@Data
public class CreateShuffledConsequenceResponse {
    List<Integer> consequence;
}
