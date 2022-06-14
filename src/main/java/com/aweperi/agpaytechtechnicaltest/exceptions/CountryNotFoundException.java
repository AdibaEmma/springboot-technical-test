package com.aweperi.agpaytechtechnicaltest.exceptions;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException() {
        super("Country Not Found");
    }

    public CountryNotFoundException(String message) {
        super(message);
    }


}
