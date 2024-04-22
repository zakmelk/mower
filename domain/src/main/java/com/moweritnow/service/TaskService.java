package com.moweritnow.service;

import com.moweritnow.model.Lawn;
import com.moweritnow.model.Task;
import com.moweritnow.ports.IMowerDisplay;
import com.moweritnow.ports.ITaskBuilder;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.Queue;
import java.util.function.BiConsumer;

@AllArgsConstructor
public class TaskService {
    private ITaskBuilder taskBuilder;
    private IMowerDisplay mowerDisplay;
    public void launch() {
        Map<Lawn, Queue<Task>> tasksPerLawn = getTasksPerLawn();
        BiConsumer<Lawn, Queue<Task>> tasksPerLawnConsumer = (lawn, tasks) -> tasks.stream().forEach(t -> mowerDisplay.display(t.executeOrders(lawn)));
        tasksPerLawn.forEach((lawn, tasks) -> tasksPerLawnConsumer.accept(lawn, tasks));
    }
    public Map<Lawn, Queue<Task>> getTasksPerLawn(){
        return taskBuilder.getTasks();
    }
}
