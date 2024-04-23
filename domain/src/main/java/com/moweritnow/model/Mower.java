package com.moweritnow.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Builder
@Getter
public class Mower {
    private Position position;
    private OrientationEnum orientation;

    public void executeOrder(OrderEnum order) {
        switch (order) {
            case A -> moveForward();
            case D -> turnRight();
            case G -> turnLeft();
            default -> doNothing();
        }
    }

    private void doNothing() {
    }

    public boolean isValidOrder(Lawn lawn, OrderEnum order) {
        if (OrderEnum.A.equals(order)) {
            switch (orientation) {
                case N -> {
                    return position.getY() < lawn.m();
                }
                case E -> {
                    return position.getX() < lawn.n();
                }
                case S -> {
                    return position.getY() > 0;
                }
                case W -> {
                    return position.getX() > 0;
                }
                default -> {
                    return false;
                }
            }
        }
        return true;
    }

    private void turnLeft() {
        switch (orientation) {
            case N -> orientation = OrientationEnum.W;
            case E -> orientation = OrientationEnum.N;
            case S -> orientation = OrientationEnum.E;
            case W -> orientation = OrientationEnum.S;
            default -> doNothing();
        }
    }

    private void turnRight() {
        switch (orientation) {
            case N -> orientation = OrientationEnum.E;
            case E -> orientation = OrientationEnum.S;
            case S -> orientation = OrientationEnum.W;
            case W -> orientation = OrientationEnum.N;
            default -> doNothing();
        }
    }

    public void moveForward() {
        switch (orientation) {
            case N -> position.moveToNorth();
            case E -> position.moveToEast();
            case W -> position.moveToWest();
            case S -> position.moveToSouth();
            default -> doNothing();
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s", position, orientation);
    }
}