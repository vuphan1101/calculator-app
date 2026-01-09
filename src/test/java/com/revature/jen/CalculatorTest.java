package com.revature.jen;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }


    @Test
    @DisplayName("Should add two positive numbers")
    void testAddPositiveNumbers() {
        Assertions.assertEquals(8, calculator.add(5, 3));
    }

    @Test
    @DisplayName("Should add positive and negative numbers")
    void testAddMixedNumbers() {
        Assertions.assertEquals(2, calculator.add(5, -3));
    }

    @Test
    @DisplayName("Should add two negative numbers")
    void testAddNegativeNumbers() {
        Assertions.assertEquals(-8, calculator.add(-5, -3));
    }

    @Test
    @DisplayName("Should return same number when adding zero")
    void testAddZero() {
        Assertions.assertEquals(5, calculator.add(5, 0));
        Assertions.assertEquals(5, calculator.add(0, 5));
    }
    @ParameterizedTest(name = "add({0}, {1}) = {2}")
    @CsvSource({
            "2, 3, 5",
            "5, -3, 2",
            "-2, -3, -5",
            "0, 0, 0"
    })
    @DisplayName("add() should return correct sum for mixed inputs")
    void testAddParameterized(int a, int b, int expected) {
        Assertions.assertEquals(expected, calculator.add(a, b));
    }
}
