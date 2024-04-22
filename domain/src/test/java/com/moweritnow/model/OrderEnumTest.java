package com.moweritnow.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderEnumTest {

    @Test
    void fromString() {
        assertEquals(OrderEnum.D,OrderEnum.fromString("D"));
        assertEquals(OrderEnum.UNDEFINED,OrderEnum.fromString(""));
        assertEquals(OrderEnum.UNDEFINED,OrderEnum.fromString(null));
    }
}