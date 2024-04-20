package com.moweritnow.model;

public class InvalidOrderException extends Exception {
    private final char order;

    public InvalidOrderException(String message, char order) {
        super(message);
        this.order = order;
    }
}
