package com.moweritnow.service;

import com.moweritnow.model.Lawn;
import com.moweritnow.model.Task;
import com.moweritnow.ports.out.IMowerDisplay;
import com.moweritnow.ports.in.ITaskBuilder;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.Queue;
import java.util.function.BiConsumer;

@AllArgsConstructor
public class MowerService {
    private ITaskBuilder taskBuilder;
    public void launch(IMowerDisplay mowerDisplay) {
        Map<Lawn, Queue<Task>> tasksPerLawn = getTasksPerLawn();
        BiConsumer<Lawn, Queue<Task>> tasksPerLawnConsumer = (lawn, tasks) -> tasks.stream().forEach(t -> mowerDisplay.display(t.executeOrders(lawn)));
        tasksPerLawn.forEach((lawn, tasks) -> tasksPerLawnConsumer.accept(lawn, tasks));
    }
    private Map<Lawn, Queue<Task>> getTasksPerLawn(){
        return taskBuilder.getTasks();
    }
}
