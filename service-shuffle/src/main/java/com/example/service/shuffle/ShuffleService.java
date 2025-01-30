package com.example.service.shuffle;

import com.example.dto.CreateShuffledConsequenceRequest;
import com.example.dto.CreateShuffledConsequenceResponse;

public interface ShuffleService {

    CreateShuffledConsequenceResponse createShuffledConsequence(CreateShuffledConsequenceRequest request);
}
