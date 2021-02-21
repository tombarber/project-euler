package com.tombarber.euler.p54poker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.tombarber.euler.p54poker.Card.CardBuilder.aCard;
import static com.tombarber.euler.p54poker.CardValue.*;
import static com.tombarber.euler.p54poker.Suit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class P54PokerGameTest {
    // https://projecteuler.net/problem=54

    private P54PokerGame pokerGame;

    @BeforeEach
    void setUp() {
        pokerGame = new P54PokerGame();
    }

    @Nested
    class Examples {
        @Test
        void example1() {
            // P1: 5H 5C 6S 7S KD - Pair of Fives
            // P2: 2C 3S 8S 8D TD - Pair of Eights
            final PokerHand player1 = new PokerHand(
                    aCard().withValue(FIVE).withSuit(HEARTS).build(),
                    aCard().withValue(FIVE).withSuit(CLUBS).build(),
                    aCard().withValue(SIX).withSuit(SPADES).build(),
                    aCard().withValue(SEVEN).withSuit(SPADES).build(),
                    aCard().withValue(KING).withSuit(DIAMONDS).build()
            );

            final PokerHand player2 = new PokerHand(
                    aCard().withValue(TWO).withSuit(CLUBS).build(),
                    aCard().withValue(THREE).withSuit(SPADES).build(),
                    aCard().withValue(EIGHT).withSuit(SPADES).build(),
                    aCard().withValue(EIGHT).withSuit(DIAMONDS).build(),
                    aCard().withValue(TEN).withSuit(DIAMONDS).build()
            );

            assertThat(pokerGame.whoWon(player1, player2)).isEqualTo(PokerResult.PLAYER_TWO);
        }
    }
}
