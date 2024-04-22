package com.moweritnow.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrientationEnumTest {

    @Test
    void fromString() {
        assertEquals(OrientationEnum.N,OrientationEnum.fromString("N"));
        assertEquals(OrientationEnum.UNDEFINED,OrientationEnum.fromString("K"));
        assertEquals(OrientationEnum.UNDEFINED,OrientationEnum.fromString(""));
        assertEquals(OrientationEnum.UNDEFINED,OrientationEnum.fromString(null));
    }
}