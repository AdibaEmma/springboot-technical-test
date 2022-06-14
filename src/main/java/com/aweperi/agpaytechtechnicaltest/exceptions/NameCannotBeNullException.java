package com.aweperi.agpaytechtechnicaltest.exceptions;

public class NameCannotBeNullException extends RuntimeException {
    public NameCannotBeNullException() {
        super("Country name cannot be null or empty");
    }
}
