package com.example.requestlogging;


import com.example.dto.CreateShuffledConsequenceRequest;
import com.example.dto.CreateShuffledConsequenceResponse;
import java.util.List;

public interface RequestLoggingClient {

    void logCreateShuffledConsequenceRequest(CreateShuffledConsequenceRequest request);
}
