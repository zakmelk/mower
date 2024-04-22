package com.moweritnow.model;

import com.moweritnow.model.exception.InvalidOrderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderEnumTest {

    @Test
    public void testFromChar_valid() throws InvalidOrderException {
        // Given
        char c = 'A';
        // When
        OrderEnum orderEnum = OrderEnum.fromChar(c);
        // Then
        assertEquals(OrderEnum.A,orderEnum);
    }

    @Test
    public void testFromChar_notValid() {
        // Given
        char c = 'E';
        // When
        Exception exception = assertThrows(InvalidOrderException.class,()->{
            OrderEnum.fromChar(c);
        });
        // Then
        assertInstanceOf(InvalidOrderException.class,exception);
        assertEquals(c,((InvalidOrderException)exception).getOrder());
    }

}