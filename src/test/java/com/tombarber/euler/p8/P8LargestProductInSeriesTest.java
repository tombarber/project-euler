package com.tombarber.euler.p8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.*;

public class P8LargestProductInSeriesTest {

    /*
    The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.

    Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
     */
    private static final String THOUSAND_DIGIT_NUMBER = "73167176531330624919225119674426574742355349194934" +
            "96983520312774506326239578318016984801869478851843" +
            "85861560789112949495459501737958331952853208805511" +
            "12540698747158523863050715693290963295227443043557" +
            "66896648950445244523161731856403098711121722383113" +
            "62229893423380308135336276614282806444486645238749" +
            "30358907296290491560440772390713810515859307960866" +
            "70172427121883998797908792274921901699720888093776" +
            "65727333001053367881220235421809751254540594752243" +
            "52584907711670556013604839586446706324415722155397" +
            "53697817977846174064955149290862569321978468622482" +
            "83972241375657056057490261407972968652414535100474" +
            "82166370484403199890008895243450658541227588666881" +
            "16427171479924442928230863465674813919123162824586" +
            "17866458359124566529476545682848912883142607690042" +
            "24219022671055626321111109370544217506941658960408" +
            "07198403850962455444362981230987879927244284909188" +
            "84580156166097919133875499200524063689912560717606" +
            "05886116467109405077541002256983155200055935729725" +
            "71636269561882670428252483600823257530420752963450";

    private StringProductCalculator stringProductCalculator;
    private P8LargestProductInSeries p8LargestProductInSeries;

    @BeforeEach
    void setUp() {
        stringProductCalculator = new StringProductCalculator();
    }

    @Nested
    class ConstructorPreconditions {

        @Test
        void stringProductCalculatorMustNotBeNull() {
            assertThatNullPointerException()
                    .isThrownBy(() -> new P8LargestProductInSeries(THOUSAND_DIGIT_NUMBER, null))
                    .withMessage("stringProductCalculator must not be null");
        }

        @Test
        void seriesMustNotBeNull() {
            assertThatNullPointerException()
                    .isThrownBy(() -> new P8LargestProductInSeries(null, stringProductCalculator))
                    .withMessage("series must not be null or blank");
        }

        @Test
        void seriesMustNotBeBlank() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new P8LargestProductInSeries("", stringProductCalculator))
                    .withMessage("series must not be null or blank");
        }

        @Test
        void seriesMustOnlyContainNumericalValues() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new P8LargestProductInSeries("123456ZZZ456", stringProductCalculator))
                    .withMessage("series must only contain the chars 0-9");
        }
    }

    @Nested
    class FindLargestProductOfAdjacentNumbers {

        @BeforeEach
        void setUp() {
            p8LargestProductInSeries = new P8LargestProductInSeries(THOUSAND_DIGIT_NUMBER, stringProductCalculator);
        }

        @Nested
        class Preconditions {
            @Test
            void groupSizeMustBeGreaterThanZero() {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> p8LargestProductInSeries.findLargestProductOfAdjacentNumbers(0))
                        .withMessage("groupSize must be greater than zero");
            }

            @Test
            void groupSizeMustBeLessThanOrEqualToSeriesLength() {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> p8LargestProductInSeries.findLargestProductOfAdjacentNumbers(1001))
                        .withMessage("groupSize must be less than or equal to the series length");
            }
        }

        @Test
        void simple() {
            assertThat(new P8LargestProductInSeries("234589", stringProductCalculator).findLargestProductOfAdjacentNumbers(3)).isEqualTo(360);
        }

        @Test
        void example() {
            assertThat(p8LargestProductInSeries.findLargestProductOfAdjacentNumbers(4)).isEqualTo(5832);
        }

        @Test
        void answer() {
            final BigInteger answer = p8LargestProductInSeries.findLargestProductOfAdjacentNumbers(13);
            assertThat(answer).isEqualTo(new BigInteger("23514624000"));
            System.out.println("THE ANSWER IS: " + answer);
        }
    }

}
