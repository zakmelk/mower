package com.moweritnow.in;

import com.moweritnow.model.*;
import com.moweritnow.ports.in.ITaskBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;

import java.util.*;

import static com.moweritnow.in.InputValidator.*;

@Slf4j
public class TaskBuilderFileAdapter implements ITaskBuilder {
    Map<Lawn, Queue<Task>> tasksPerLawn;

    public TaskBuilderFileAdapter() {
        tasksPerLawn = new HashMap<>();
    }

    @Override
    public Map<Lawn, Queue<Task>> getTasks() {
        return tasksPerLawn;
    }

    @Override
    public void loadTasks(String fileName) {
        if (isFileValid(fileName)) {
            List<String> lines = getLines(fileName);
            Lawn lawn = getLawn(lines.get(0));
            Queue<Task> tasks = new LinkedList<>();
            List<List<String>> tasksInput = ListUtils.partition(lines.subList(1, lines.size()), 2);
            for (List<String> taskInput : tasksInput) {
                if (taskInput.size() == 2) {
                    tasks.add(new Task(getMower(taskInput.get(0)), getOrders(taskInput.get(1))));
                }
            }
            tasksPerLawn.put(lawn, tasks);
        }
    }

    public static Lawn getLawn(String input) {
        String[] split = input.split(DELIMITER_SPACE);
        return new Lawn(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
    }


    public static Mower getMower(String input) {
        String[] split = input.split(DELIMITER_SPACE);
        return Mower.builder()
                .position(new Position(split[0], split[1]))
                .orientation(OrientationEnum.valueOf(split[2]))
                .build();
    }

    public static List<OrderEnum> getOrders(String ordersInput) {
            return Arrays.stream(ordersInput.split("")).map(OrderEnum::fromString).toList();
    }

}
