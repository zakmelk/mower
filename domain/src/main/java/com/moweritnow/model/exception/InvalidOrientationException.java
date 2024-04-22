package com.moweritnow.model.exception;

import lombok.Getter;

@Getter
public class InvalidOrientationException extends Exception {
    private final char orientation;

    public InvalidOrientationException(String message, char orientation) {
        super(message);
        this.orientation = orientation;
    }
}
