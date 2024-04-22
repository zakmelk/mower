package com.moweritnow.model;

import org.apache.commons.lang3.StringUtils;

public enum OrientationEnum {
    N,E,W,S,UNDEFINED;
    public static OrientationEnum fromString(String value) {
        if(StringUtils.isNotBlank(value)){
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
        return OrientationEnum.UNDEFINED;
    }
}
