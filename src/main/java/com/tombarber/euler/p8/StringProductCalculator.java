package com.tombarber.euler.p8;

import org.apache.commons.lang3.Validate;

import java.math.BigInteger;

public class StringProductCalculator {
    public BigInteger calculate(String numSequence) {
        Validate.notBlank(numSequence, "numSequence must not be null or blank");
        Validate.matchesPattern(numSequence, "[0-9]*", "numSequence must only contain the chars 0-9");
        return numSequence.codePoints()
                .mapToObj(c -> (char) c)
                .map(Character::getNumericValue)
                .map(BigInteger::valueOf)
                .reduce(BigInteger.valueOf(1), BigInteger::multiply);
    }
}
