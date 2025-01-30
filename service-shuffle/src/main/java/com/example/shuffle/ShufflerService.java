package com.example.shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ShufflerService {

    public List<Integer> shuffleNumbers(int n) {

        if (n < 1 || n > 1000) {
            throw new IllegalArgumentException("Number must be between 1 and 1000");
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }
}
