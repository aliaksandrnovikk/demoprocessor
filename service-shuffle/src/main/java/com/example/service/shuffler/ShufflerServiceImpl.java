package com.example.service.shuffler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class ShufflerServiceImpl implements ShufflerService {

    @Override
    public List<Integer> shuffleNumbers(Integer n) {
        if (n < 1 || n > 1000) {
            throw new IllegalArgumentException("Number must be between 1 and 1000");
        }
        List<Integer> numbers = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);

        return numbers;
    }

}
