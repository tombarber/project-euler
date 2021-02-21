package com.tombarber.euler.p8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringProductCalculatorTest {

    private StringProductCalculator stringProductCalculator;

    @BeforeEach
    void setUp() {
        stringProductCalculator = new StringProductCalculator();
    }

    @Nested
    class Preconditions {
        @Test
        void numSequenceMustNotBeNull() {
            assertThatNullPointerException()
                    .isThrownBy(() -> stringProductCalculator.calculate(null))
                    .withMessage("numSequence must not be null or blank");
        }

        @Test
        void numSequenceMustNotBeBlank() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> stringProductCalculator.calculate(""))
                    .withMessage("numSequence must not be null or blank");
        }

        @Test
        void numSequenceMustOnlyContainNumericalValues() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> stringProductCalculator.calculate("123456ZZZ456"))
                    .withMessage("numSequence must only contain the chars 0-9");
        }
    }

    @Test
    void canCalculateProduct() {
        assertThat(stringProductCalculator.calculate("1234")).isEqualTo(24);
    }
    @Test
    void canCalculateProductXX() {
        assertThat(stringProductCalculator.calculate("7536978179778")).isEqualTo(24);
    }
}
