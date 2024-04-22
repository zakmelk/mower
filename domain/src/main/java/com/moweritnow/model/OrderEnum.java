package com.moweritnow.model;

import com.moweritnow.model.exception.InvalidOrderException;

import static com.moweritnow.utils.Constants.INVALID_ORDER;

public enum OrderEnum {
    A,D,G,UNDEFINED;

    public static OrderEnum fromString(String value) {
        switch (value) {
            case "A" :
                return OrderEnum.A;
            case "D" :
                return OrderEnum.D;
            case "G" :
                return OrderEnum.G;
            default:
                return OrderEnum.UNDEFINED;
        }
    }

}
