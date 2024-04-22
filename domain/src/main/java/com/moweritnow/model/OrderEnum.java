package com.moweritnow.model;

import org.apache.commons.lang3.StringUtils;

public enum OrderEnum {
    A,D,G,UNDEFINED;

    public static OrderEnum fromString(String value) {
        if(StringUtils.isNotBlank(value)){
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
        return OrderEnum.UNDEFINED;
    }

}
