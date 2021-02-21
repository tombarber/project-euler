package com.tombarber.euler.p8;

import org.apache.commons.lang3.Validate;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class P8LargestProductInSeries {
    private final String series;
    private final StringProductCalculator stringProductCalculator;

    public P8LargestProductInSeries(final String series, StringProductCalculator stringProductCalculator) {
        this.stringProductCalculator = Validate.notNull(stringProductCalculator, "stringProductCalculator must not be null");
        Validate.notBlank(series, "series must not be null or blank");
        Validate.matchesPattern(series, "[0-9]*", "series must only contain the chars 0-9");
        this.series = series;
    }

    public BigInteger findLargestProductOfAdjacentNumbers(int groupSize) {
        Validate.isTrue(groupSize > 0, "groupSize must be greater than zero");
        Validate.isTrue(groupSize <= series.length(), "groupSize must be less than or equal to the series length");

        return IntStream.range(0, getNumberOfSequences(groupSize))
                .mapToObj(i -> getNextSequence(groupSize, i))
                .map(stringProductCalculator::calculate)
                .max(BigInteger::compareTo)
                .orElse(BigInteger.ZERO);
    }

    private int getNumberOfSequences(int groupSize) {
        return series.length() - groupSize + 1;
    }

    private String getNextSequence(int groupSize, int i) {
        return series.substring(i, i + groupSize);
    }
}
