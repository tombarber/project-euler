package com.tombarber.euler.p54poker;

public enum CardValue implements Comparable<CardValue> {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11, 'J'),
    QUEEN(12, 'Q'),
    KING(13, 'K'),
    ACE(14, 'A');

    private final int value;
    private final char charRepresentation;

    CardValue(int value) {
        this.value = value;
        this.charRepresentation = Character.forDigit(value, 10);
    }

    CardValue(int value, char charRepresentation) {
        this.value = value;
        this.charRepresentation = charRepresentation;
    }

    public int getValue() {
        return value;
    }

    public char getCharRepresentation() {
        return charRepresentation;
    }
}
