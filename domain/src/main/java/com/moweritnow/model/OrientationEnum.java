package com.moweritnow.model;

import static com.moweritnow.utils.Constants.INVALID_ORIENTATION;

public enum OrientationEnum {
    N,E,W,S;
    public static OrientationEnum fromChar(char c) throws InvalidOrderException {
        switch (c) {
            case 'N' :
                return OrientationEnum.N;
            case 'E' :
                return OrientationEnum.E;
            case 'W' :
                return OrientationEnum.W;
            case 'S' :
                return OrientationEnum.S;
            default:
                throw new InvalidOrderException(INVALID_ORIENTATION,c);
        }
    }
}
