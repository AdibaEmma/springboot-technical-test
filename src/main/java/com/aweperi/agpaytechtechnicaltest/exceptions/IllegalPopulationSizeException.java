package com.aweperi.agpaytechtechnicaltest.exceptions;

public class IllegalPopulationSizeException extends RuntimeException {
    public IllegalPopulationSizeException() {
        super("Country Population must be greater than zero");
    }

    public IllegalPopulationSizeException(String message) {
        super(message);
    }
}
