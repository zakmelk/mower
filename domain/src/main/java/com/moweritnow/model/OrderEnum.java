package com.moweritnow.model;

import static com.moweritnow.utils.Constants.INVALID_ORDER;

public enum OrderEnum {
    A,D,G;

    public static OrderEnum fromChar(char c) throws InvalidOrderException {
        switch (c) {
            case 'A' :
                return OrderEnum.A;
            case 'D' :
                return OrderEnum.D;
            case 'G' :
                return OrderEnum.G;
            default:
                throw new InvalidOrderException(INVALID_ORDER,c);
        }
    }

}
