package com.tombarber.euler.p54poker;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SuitTest {
    @Nested
    class RepresentedBy {
        @ParameterizedTest
        @EnumSource(value = Suit.class)
        void canFindKnownValues(final Suit suit) {
            assertThat(Suit.representedBy(suit.getCharRepresentation())).isEqualTo(suit);
        }

        @Test
        void willThrowIfNoSuitForChar(){
            assertThatExceptionOfType(SuitNotFoundException.class)
                    .isThrownBy(() -> Suit.representedBy('x'))
                    .withMessage("No suit found for char x");
        }
    }
}