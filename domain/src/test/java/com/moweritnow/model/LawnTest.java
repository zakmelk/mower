package com.moweritnow.model;

import com.moweritnow.model.exception.LawnIllegalArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LawnTest {
    @Test
    void lawn_negative() {
        assertThrows(LawnIllegalArgumentException.class, () -> new Lawn(-1, 2));
        assertThrows(LawnIllegalArgumentException.class, () -> new Lawn(1, -2));
        assertThrows(LawnIllegalArgumentException.class, () -> new Lawn(-1, -2));
    }
}