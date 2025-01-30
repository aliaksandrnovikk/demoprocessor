package com.example.requestlogging;

import com.example.dto.CreateShuffledConsequenceRequest;
import com.example.dto.CreateShuffledConsequenceResponse;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
public class RequestLoggingClientImpl implements RequestLoggingClient {

    private final WebClient webClient;

    public RequestLoggingClientImpl(String baseUrl) {
        webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    @Override
    public void logCreateShuffledConsequenceRequest(CreateShuffledConsequenceRequest request) {
        webClient.post()
                .uri("/log")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .toBodilessEntity()
                .subscribe(voidResponseEntity -> {
                    log.error(voidResponseEntity.getBody().toString());
                });
    }
}