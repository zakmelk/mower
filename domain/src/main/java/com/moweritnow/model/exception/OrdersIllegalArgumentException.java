package com.moweritnow.model.exception;

public class OrdersIllegalArgumentException extends IllegalArgumentException{
    public OrdersIllegalArgumentException(String message, String argument) {
        super(String.format(message,argument));
    }
}
