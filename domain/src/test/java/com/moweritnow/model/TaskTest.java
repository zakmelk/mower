package com.moweritnow.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {

    @Test
    void executeOrders_case1() {
        // Given
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(1, 2);
        Mower mower = new Mower(position, OrientationEnum.N);
        List<OrderEnum> orders = List.of(OrderEnum.G, OrderEnum.A, OrderEnum.G, OrderEnum.A, OrderEnum.G, OrderEnum.A, OrderEnum.G, OrderEnum.A, OrderEnum.A);
        Task task = new Task(mower, orders);
        // When
        task.executeOrders(lawn);
        // Then
        assertEquals(1, mower.getPosition().getX());
        assertEquals(3, mower.getPosition().getY());
        assertEquals(OrientationEnum.N, mower.getOrientation());
    }

    @Test
    void executeOrders_case2() {
        // Given
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(3, 3);
        Mower mower = new Mower(position, OrientationEnum.E);
        List<OrderEnum> orders = List.of(OrderEnum.A, OrderEnum.A, OrderEnum.D, OrderEnum.A, OrderEnum.A, OrderEnum.D, OrderEnum.A, OrderEnum.D, OrderEnum.D, OrderEnum.A);
        Task task = new Task(mower, orders);
        // When
        task.executeOrders(lawn);
        // Then
        assertEquals(5, mower.getPosition().getX());
        assertEquals(1, mower.getPosition().getY());
        assertEquals(OrientationEnum.E, mower.getOrientation());
    }


    @Test
    void executeOrders_case3() {
        // Given
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(3, 3);
        Mower mower = new Mower(position, OrientationEnum.W);
        List<OrderEnum> orders = List.of(OrderEnum.A, OrderEnum.A, OrderEnum.A, OrderEnum.A, OrderEnum.G, OrderEnum.A, OrderEnum.A, OrderEnum.A, OrderEnum.A, OrderEnum.A);
        Task task = new Task(mower, orders);
        // When
        task.executeOrders(lawn);
        // Then
        assertEquals(0, mower.getPosition().getX());
        assertEquals(0, mower.getPosition().getY());
        assertEquals(OrientationEnum.S, mower.getOrientation());
    }
}