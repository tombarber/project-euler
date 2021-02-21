package com.tombarber.euler.p1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class P1Multiples3Or5Test {
    private P1Multiples3Or5 multiples3Or5;

    @BeforeEach
    void setUp() {
        multiples3Or5 = new P1Multiples3Or5();
    }

    @Test
    void upperBoundaryMustBePositive() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> multiples3Or5.sumOfThoseLessThan(0))
                .withMessage("upperBoundary must be positive");
    }

    @Test
    void sumOfMultiplesLessThanTen() {
        assertThat(multiples3Or5.sumOfThoseLessThan(10)).isEqualTo(23);
    }

    @Test
    void sumOfMultiplesLessThanOneThousand() {
        final int problemAnswer = multiples3Or5.sumOfThoseLessThan(1000);
        System.out.printf("The answer is %d", problemAnswer);
        assertThat(problemAnswer).isEqualTo(233168);
    }
}
