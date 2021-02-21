package com.tombarber.euler.p1;

import org.apache.commons.lang3.Validate;

import java.util.stream.IntStream;

public class P1Multiples3Or5 {

    public int sumOfThoseLessThan(int upperBoundary) {
        Validate.isTrue(upperBoundary > 0, "upperBoundary must be positive");

        return IntStream
                .range(0, upperBoundary)
                .filter(i -> (i % 3 == 0 || i % 5 == 0))
                .sum();
    }
}
