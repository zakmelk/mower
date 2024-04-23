package com.moweritnow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
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
        return String.format("%s %s",x,y);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Position)) {
            return false;
        }
        Position other = (Position) o;
        return x == other.x && y == other.y;
    }
}
