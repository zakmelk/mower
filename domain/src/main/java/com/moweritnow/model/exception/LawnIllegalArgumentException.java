package com.moweritnow.model.exception;

public class LawnIllegalArgumentException extends IllegalArgumentException {
    public LawnIllegalArgumentException(String message, int n, int m) {
        super(String.format(message, n, m));
    }
}
