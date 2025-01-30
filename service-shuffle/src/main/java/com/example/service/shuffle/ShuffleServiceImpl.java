package com.example.service.shuffle;

import com.example.dto.CreateShuffledConsequenceRequest;
import com.example.dto.CreateShuffledConsequenceResponse;
import com.example.requestlogging.RequestLoggingClient;
import com.example.service.shuffler.ShufflerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShuffleServiceImpl implements ShuffleService {

    private final RequestLoggingClient requestLoggingClient;
    private final ShufflerServiceImpl shuffleService;

    @Autowired
    public ShuffleServiceImpl(RequestLoggingClient requestLoggingClient, ShufflerServiceImpl shuffleService) {
        this.requestLoggingClient = requestLoggingClient;
        this.shuffleService = shuffleService;
    }

    @Override
    public CreateShuffledConsequenceResponse createShuffledConsequence(CreateShuffledConsequenceRequest request) {
        List<Integer> shuffledNumbers = shuffleService.shuffleNumbers(request.getN());
        request.setShuffledNumbers(shuffledNumbers);
        requestLoggingClient.logCreateShuffledConsequenceRequest(request);
        return new CreateShuffledConsequenceResponse(shuffledNumbers);
    }
}
