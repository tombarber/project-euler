package com.tombarber.euler.p54poker;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@ExtendWith(MockitoExtension.class)
public class PokerHandTest {

    @Nested
    class ConstructorPreconditions {

        @Mock
        private Card card;

        @Test
        void card1MustNotBeNull() {
            assertThatNullPointerException()
                    .isThrownBy(() -> new PokerHand(null, card, card, card, card))
                    .withMessage("card1 must not be null");
        }

        @Test
        void card2MustNotBeNull() {
            assertThatNullPointerException()
                    .isThrownBy(() -> new PokerHand(card, null, card, card, card))
                    .withMessage("card2 must not be null");
        }

        @Test
        void card3MustNotBeNull() {
            assertThatNullPointerException()
                    .isThrownBy(() -> new PokerHand(card, card, null, card, card))
                    .withMessage("card3 must not be null");
        }

        @Test
        void card4MustNotBeNull() {
            assertThatNullPointerException()
                    .isThrownBy(() -> new PokerHand(card, card, card, null, card))
                    .withMessage("card4 must not be null");
        }

        @Test
        void card5MustNotBeNull() {
            assertThatNullPointerException()
                    .isThrownBy(() -> new PokerHand(card, card, card, card, null))
                    .withMessage("card5 must not be null");
        }

    }

    @Nested
    class RoyalFlush {
        //Royal Flush: Ten, Jack, Queen, King, Ace, in same suit

        @Test
        void tenThroughAceSameSuitIsRoyalFlush() {

        }
    }
}
