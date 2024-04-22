package com.moweritnow.out;

import com.moweritnow.model.Mower;
import com.moweritnow.model.OrientationEnum;
import com.moweritnow.model.Position;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ConsoleMowerDisplayTest {

    @Test
    void display() {
        Mower mower = new Mower(new Position(2,2), OrientationEnum.E);
        ConsoleMowerDisplay mowerDisplay = mock(ConsoleMowerDisplay.class);
        doNothing().when(mowerDisplay).display(mower);
        mowerDisplay.display(mower);
        verify(mowerDisplay,times(1)).display(mower);
    }
}