package com.moweritnow.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position {
    private int x;
    private int y;
    public void moveToNorth(){
        y++;
    }
    public void moveToEast(){
        x++;
    }
    public void moveToSouth(){
        y--;
    }
    public void moveToWest(){
        x--;
    }

    @Override
    public String toString(){
        return x+","+y;
    }
}
