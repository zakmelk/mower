package com.moweritnow.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MowerTest {

    @Test
    void executeOrder_A() {
        // Given
        Position position = new Position(1, 1);
        Mower mower = new Mower(position, OrientationEnum.E);
        // When
        mower.executeOrder(OrderEnum.A);
        // Then
        assertEquals(2, mower.getPosition().getX());
        assertEquals(1, mower.getPosition().getY());
        assertEquals(OrientationEnum.E, mower.getOrientation());
    }

    @Test
    void executeOrder_D() {
        // Given
        Position position = new Position(1, 1);
        Mower mower = new Mower(position, OrientationEnum.E);
        // When
        mower.executeOrder(OrderEnum.D);
        // Then
        assertEquals(1, position.getX());
        assertEquals(1, position.getY());
        assertEquals(OrientationEnum.S, mower.getOrientation());
    }

    @Test
    void isValidOrder_false() {
        // Given
        Position position = new Position(1, 0);
        Mower mower = new Mower(position, OrientationEnum.S);
        Lawn lawn = new Lawn(2, 2);
        // When
        boolean validOrder = mower.isValidOrder(lawn, OrderEnum.A);
        // Then
        assertFalse(validOrder);
    }

    @Test
    void isValidOrder_true() {
        // Given
        Position position = new Position(1, 1);
        Mower mower = new Mower(position, OrientationEnum.S);
        Lawn lawn = new Lawn(2, 2);
        // When
        boolean validOrder = mower.isValidOrder(lawn, OrderEnum.A);
        // Then
        assertTrue(validOrder);
    }

    @Test
    void moveForward() {
        // Given
        Position position = new Position(1, 1);
        Mower mower = new Mower(position, OrientationEnum.E);
        // When
        mower.moveForward();
        // Then
        assertEquals(2, mower.getPosition().getX());
        assertEquals(1, mower.getPosition().getY());
        assertEquals(OrientationEnum.E, mower.getOrientation());
    }
}