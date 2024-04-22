package com.moweritnow.model;

import com.moweritnow.model.exception.LawnIllegalArgumentException;

public record Lawn(int n, int m) {
    public Lawn {
        if (n < 0 || m < 0) {
            throw new LawnIllegalArgumentException("Lawn attributes (%d,%d) are not valid !", n, m);
        }
    }
}
