package com.example.controller;

import com.example.dto.CreateShuffledConsequenceRequest;
import com.example.dto.CreateShuffledConsequenceResponse;
import com.example.service.shuffle.ShuffleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/shuffle")
public class ShuffleController {

    private final ShuffleService shuffleService;

    @PostMapping
    public CreateShuffledConsequenceResponse createShuffledConsequence(@RequestBody CreateShuffledConsequenceRequest request) {
        return shuffleService.createShuffledConsequence(request);
    }
}
