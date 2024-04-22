package com.moweritnow.model;

import com.moweritnow.model.exception.InvalidOrderException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.moweritnow.utils.InputValidator.*;

@Slf4j
@AllArgsConstructor
@Builder
public class Mower {
    private Position position;
    private OrientationEnum orientation;

    public void executeOrder(OrderEnum order) {
        switch (order) {
            case A -> moveForward();
            case D -> turnRight();
            case G -> turnLeft();
        }
    }


    public boolean isValidOrder(Lawn lawn, OrderEnum order) {
        if (OrderEnum.A.equals(order)) {
            switch (orientation) {
                case N -> {
                    return position.getY() < lawn.m() ? true : false;
                }
                case E -> {
                    return position.getX() < lawn.n() ? true : false;
                }
                case S -> {
                    return position.getY() > 0 ? true : false;
                }
                case W -> {
                    return position.getX() > 0 ? true : false;
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
        }
    }

    private void turnRight() {
        switch (orientation) {
            case N -> orientation = OrientationEnum.E;
            case E -> orientation = OrientationEnum.S;
            case S -> orientation = OrientationEnum.W;
            case W -> orientation = OrientationEnum.N;
        }
    }

    public void moveForward() {
        switch (orientation) {
            case N -> position.moveToNorth();
            case E -> position.moveToEast();
            case W -> position.moveToWest();
            case S -> position.moveToSouth();
        }
    }

    @Override
    public String toString() {
        return (new StringBuilder()).append("(").append(position).append(",").append(orientation).append(")").toString();
    }
}