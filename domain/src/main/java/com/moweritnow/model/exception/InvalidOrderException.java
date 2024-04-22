package com.moweritnow.model.exception;

import lombok.Getter;

@Getter
public class InvalidOrderException extends Exception {

    public InvalidOrderException(String message, String value) {
        super(String.format(message,value));
    }
}
