package com.tombarber.euler.p54poker;

import java.util.Arrays;

public enum Suit {
    SPADES('S'),
    DIAMONDS('D'),
    HEARTS('H'),
    CLUBS('C');

    private char charRepresentation;

    Suit(char charRepresentation) {
        this.charRepresentation = charRepresentation;
    }

    public char getCharRepresentation() {
        return charRepresentation;
    }

    public static Suit representedBy(char charRepresentation){
        return Arrays.stream(values())
                .filter(card -> charRepresentation == card.getCharRepresentation())
                .findFirst()
                .orElseThrow(() -> new SuitNotFoundException(charRepresentation));
    }
}
