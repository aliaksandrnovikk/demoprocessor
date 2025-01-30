package com.example;

import com.example.model.LogRequest;
import com.example.shuffle.ShuffleRequest;
import com.example.shuffle.ShufflerService;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class RequestProcessorController {

    private final ShufflerService shuffleService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${logging.service.url}")
    private String loggingServiceUrl;

    public RequestProcessorController(ShufflerService shuffleService) {
        this.shuffleService = shuffleService;
    }

    @PostMapping("/shuffle")
    public CompletableFuture<List<Integer>> processRequestAsync(@RequestBody ShuffleRequest shuffleRequest) {
        return CompletableFuture.supplyAsync(() -> {
            final int n = shuffleRequest.getN();
            LogRequest logRequest = new LogRequest();
            logRequest.setNumber(n);
            logRequest.setTimestamp(String.valueOf(System.currentTimeMillis()));
            logRequest.setShuffledNumbers(shuffleService.shuffleNumbers(n));

            logRequestAsync(logRequest);
            return logRequest.getShuffledNumbers();
        });
    }

    private void logRequestAsync(LogRequest logRequest) {
        CompletableFuture.runAsync(() -> {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(loggingServiceUrl, logRequest, Void.class);
        });
    }
}
