package com.tombarber.euler.p54poker;

import org.apache.commons.lang3.Validate;

public class Card {
    private Suit suit;
    private CardValue value;

    private Card(Suit suit, CardValue value) {
        this.suit = Validate.notNull(suit, "suit must not be null");
        this.value = Validate.notNull(value, "value must not be null");
    }

    public Suit getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }

    public static final class CardBuilder {
        private Suit suit;
        private CardValue value;

        private CardBuilder() {
        }

        public static CardBuilder aCard() {
            return new CardBuilder();
        }

        public CardBuilder withSuit(Suit suit) {
            this.suit = suit;
            return this;
        }

        public CardBuilder withValue(CardValue value) {
            this.value = value;
            return this;
        }

        public Card build() {
            return new Card(suit, value);
        }
    }
}
