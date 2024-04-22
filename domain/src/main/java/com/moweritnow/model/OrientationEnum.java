package com.moweritnow.model;

public enum OrientationEnum {
    N,E,W,S,UNDEFINED;
    public static OrientationEnum fromString(String value) {
        switch (value) {
            case "N" :
                return OrientationEnum.N;
            case "E" :
                return OrientationEnum.E;
            case "W" :
                return OrientationEnum.W;
            case "S" :
                return OrientationEnum.S;
            default:
                return OrientationEnum.UNDEFINED;
        }
    }
}
