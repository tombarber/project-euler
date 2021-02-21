package com.tombarber.euler.p54poker;

import org.apache.commons.lang3.Validate;

public class PokerHand {
    private final Card card1;
    private final Card card2;
    private final Card card3;
    private final Card card4;
    private final Card card5;

    public PokerHand(Card card1, Card card2, Card card3, Card card4, Card card5) {
        this.card1 = Validate.notNull(card1, "card1 must not be null");
        this.card2 = Validate.notNull(card2, "card2 must not be null");
        this.card3 = Validate.notNull(card3, "card3 must not be null");
        this.card4 = Validate.notNull(card4, "card4 must not be null");
        this.card5 = Validate.notNull(card5, "card5 must not be null");
    }
}
