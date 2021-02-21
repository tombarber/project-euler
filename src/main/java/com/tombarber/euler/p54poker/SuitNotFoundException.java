package com.tombarber.euler.p54poker;

public class SuitNotFoundException extends RuntimeException {
    public SuitNotFoundException(char charRepresentation) {
        super("No suit found for char " + charRepresentation);
    }
}
