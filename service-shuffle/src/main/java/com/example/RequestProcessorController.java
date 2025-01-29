package com.example;

import com.example.model.LogRequest;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class RequestProcessorController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${logging.service.url}")
    private String loggingServiceUrl;

    @PostMapping("/process")
    public CompletableFuture<Integer> processRequestAsync(@RequestParam("n") int n) {
        String processedData = "Processed: " + n;

        LogRequest logRequest = new LogRequest();
        logRequest.setMessage(processedData);
        logRequest.setTimestamp(String.valueOf(System.currentTimeMillis()));

        // Send the processed data to the logger service
        String response = restTemplate.postForObject(loggingServiceUrl, logRequest, String.class);
        return CompletableFuture.completedFuture("Processed and fetched response: " + response);
    }

}
