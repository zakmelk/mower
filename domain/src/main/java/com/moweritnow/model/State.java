package com.moweritnow.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class State {
    private Position position;
    private OrientationEnum orientation;
    private Lawn lawn;

    public boolean isValidState(OrderEnum order) {
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

    @Override
    public String toString() {
        return (new StringBuffer()).append("(").append(position).append(",").append(orientation).append(")").toString();
    }
}
