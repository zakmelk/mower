package com.moweritnow.service;

import com.moweritnow.model.*;
import com.moweritnow.ports.in.ITaskBuilder;
import com.moweritnow.ports.out.IMowerDisplay;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MowerServiceTest {
    @Mock
    private ITaskBuilder taskBuilder;
    @Mock
    private IMowerDisplay mowerDisplay;

    private static Map<Lawn, Queue<Task>> getLawnQueueMap() {
        Lawn lawn = new Lawn(5, 5);
        Position position1 = new Position(1, 2);
        Mower mower = new Mower(position1, OrientationEnum.N);
        List<OrderEnum> orders1 = List.of(OrderEnum.G, OrderEnum.A, OrderEnum.G, OrderEnum.A, OrderEnum.G, OrderEnum.A, OrderEnum.G, OrderEnum.A, OrderEnum.A);
        Task task1 = new Task(mower, orders1);
        Position position2 = new Position(3, 3);
        Mower mower2 = new Mower(position2, OrientationEnum.E);
        List<OrderEnum> orders2 = List.of(OrderEnum.A, OrderEnum.A, OrderEnum.D, OrderEnum.A, OrderEnum.A, OrderEnum.D, OrderEnum.A, OrderEnum.D, OrderEnum.D, OrderEnum.A);
        Task task2 = new Task(mower2, orders2);
        Map<Lawn, Queue<Task>> tasksPerLawn = new LinkedHashMap<>();
        Queue<Task> queue = new LinkedList<>();
        queue.add(task1);
        queue.add(task2);
        tasksPerLawn.put(lawn, queue);
        return tasksPerLawn;
    }

    @Test
    void launch() {
        // Given
        Map<Lawn, Queue<Task>> tasksPerLawn = getLawnQueueMap();
        when(taskBuilder.getTasks()).thenReturn(tasksPerLawn);
        doNothing().when(mowerDisplay).display(any());
        MowerService mowerService = new MowerService(taskBuilder);
        Position expectedPosition1 = new Position(1, 3);
        Position expectedPosition2 = new Position(5, 1);
        // When
        mowerService.launch(mowerDisplay);
        // Then
        Lawn lawn = new Lawn(5, 5);
        Queue<Task> tasks = tasksPerLawn.get(lawn);
        assertEquals(expectedPosition1, tasks.poll().getMower().getPosition());
        assertEquals(expectedPosition2, tasks.poll().getMower().getPosition());
    }
}