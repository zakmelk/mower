package com.moweritnow.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position {
    private int x;
    private int y;

    public Position(String sX, String sY) {
        x = Integer.parseInt(sX);
        y = Integer.parseInt(sY);
    }

    public void moveToNorth() {
        y++;
    }

    public void moveToEast() {
        x++;
    }

    public void moveToSouth() {
        y--;
    }

    public void moveToWest() {
        x--;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
