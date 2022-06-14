package com.aweperi.agpaytechtechnicaltest.exceptions;

public class CountryAlreadyExistsException extends RuntimeException {
    public CountryAlreadyExistsException() {
        super("County already exists");
    }

    public CountryAlreadyExistsException(String message) {
        super(message);
    }


}
