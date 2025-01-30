package com.example;

import static org.junit.jupiter.api.Assertions.*;

import com.example.service.shuffler.ShufflerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ShuffleServiceTest {

    @Autowired
    private ShufflerServiceImpl shuffleService;

    @BeforeEach
    public void setUp() {
        shuffleService = new ShufflerServiceImpl();
    }

    @Test
    public void testShuffleArray_validNumber() {
        int number = 10;
        List<Integer> shuffledArray = shuffleService.shuffleNumbers(number);

        assertNotNull(shuffledArray, "Shuffled array should not be null");
        assertEquals(number, shuffledArray.size(), "Shuffled array size should match the input number");
        for (int i = 1; i <= number; i++) {
            assertTrue(shuffledArray.contains(i), "Shuffled array should contain all numbers from 1 to " + number);
        }
    }

    @Test
    public void testShuffleArray_edgeCase_1() {
        int number = 1;
        List<Integer> shuffledArray = shuffleService.shuffleNumbers(number);

        assertNotNull(shuffledArray);
        assertEquals(1, shuffledArray.size());
        assertEquals(1, shuffledArray.get(0));
    }

    @Test
    public void testShuffleArray_invalidNumber() {
        int number = 1001;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            shuffleService.shuffleNumbers(number);
        });

        assertEquals("Number must be between 1 and 1000", exception.getMessage());
    }

    @Test
    public void testShuffleArray_emptyArray() {
        int number = 0;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            shuffleService.shuffleNumbers(number);
        });

        assertEquals("Number must be between 1 and 1000", exception.getMessage());
    }
}
