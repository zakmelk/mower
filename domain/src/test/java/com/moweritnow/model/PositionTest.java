package com.moweritnow.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    @Test
    void moveToNorth() {
        Position position = new Position(1, 1);
        position.moveToNorth();
        assertEquals(2, position.getY());
        assertEquals(1, position.getX());
    }

    @Test
    void moveToEast() {
        Position position = new Position(1, 1);
        position.moveToEast();
        assertEquals(1, position.getY());
        assertEquals(2, position.getX());
    }

    @Test
    void moveToSouth() {
        Position position = new Position(1, 1);
        position.moveToSouth();
        assertEquals(0, position.getY());
        assertEquals(1, position.getX());
    }

    @Test
    void moveToWest() {
        Position position = new Position(1, 1);
        position.moveToWest();
        assertEquals(1, position.getY());
        assertEquals(0, position.getX());
    }
}