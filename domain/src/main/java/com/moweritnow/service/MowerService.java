package com.moweritnow.service;

import com.moweritnow.model.Lawn;
import com.moweritnow.model.Task;
import com.moweritnow.ports.in.ITaskBuilder;
import com.moweritnow.ports.out.IMowerDisplay;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.function.BiConsumer;

@Slf4j
@AllArgsConstructor
public class MowerService {
    private ITaskBuilder taskBuilder;

    public void launch(IMowerDisplay mowerDisplay) {
        Map<Lawn, Queue<Task>> tasksPerLawn = getTasksPerLawn();
        if (Objects.nonNull(tasksPerLawn) && !tasksPerLawn.isEmpty()) {
            BiConsumer<Lawn, Queue<Task>> tasksPerLawnConsumer = (lawn, tasks) -> tasks.forEach(t -> mowerDisplay.display(t.executeOrders(lawn)));
            tasksPerLawn.forEach(tasksPerLawnConsumer::accept);
        } else {
            log.warn("No tasks to launch !");
        }
    }

    private Map<Lawn, Queue<Task>> getTasksPerLawn() {
        if (Objects.nonNull(taskBuilder)) {
            return taskBuilder.getTasks();
        }
        return new HashMap<>();
    }
}
