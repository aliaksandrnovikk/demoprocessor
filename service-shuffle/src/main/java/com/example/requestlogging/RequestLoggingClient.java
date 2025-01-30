package com.example.requestlogging;


import com.example.dto.CreateShuffledConsequenceRequest;

public interface RequestLoggingClient {

    void logCreateShuffledConsequenceRequest(CreateShuffledConsequenceRequest request);
}
