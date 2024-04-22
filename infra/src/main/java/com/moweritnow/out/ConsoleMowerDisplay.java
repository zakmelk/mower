package com.moweritnow.out;

import com.moweritnow.model.Mower;
import com.moweritnow.ports.IMowerDisplay;

public class ConsoleMowerDisplay implements IMowerDisplay {
    @Override
    public void display(Mower mower) {
        System.out.println(mower);
    }
}
