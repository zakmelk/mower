package com.moweritnow.model.exception;

public class StateIllegalArgumentException extends IllegalArgumentException{
    public StateIllegalArgumentException(String message, String argument) {
        super(String.format(message,argument));
    }
}
