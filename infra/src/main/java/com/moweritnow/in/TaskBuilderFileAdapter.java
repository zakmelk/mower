package com.moweritnow.in;

import com.moweritnow.model.*;
import com.moweritnow.model.exception.InvalidOrderException;
import com.moweritnow.model.exception.LawnIllegalArgumentException;
import com.moweritnow.ports.ITaskBuilder;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static com.moweritnow.utils.InputValidator.*;

public class TaskBuilderFileAdapter implements ITaskBuilder {
    Map<Lawn, Queue<Task>> tasksPerLawn;

    public TaskBuilderFileAdapter(){
        tasksPerLawn = new HashMap<>();
    }

    @Override
    public Map<Lawn, Queue<Task>> getTasks() {
        return tasksPerLawn;
    }

    public void loadTasks(String fileName) throws IOException, URISyntaxException {
        Path path = Paths.get(Objects.requireNonNull(TaskBuilderFileAdapter.class.getClassLoader().getResource(fileName)).toURI());
        List<String> lines = Files.readAllLines(path);
        if (Objects.nonNull(lines) && lines.size() >= 3) {
            Lawn lawn = getLawn(lines.get(0));
            Queue<Task> tasks = new LinkedList<>();
            List<List<String>> tasksInput = ListUtils.partition(lines.subList(1, lines.size()), 2);
            for(List<String> taskInput : tasksInput){
                if(taskInput.size()==2){
                    try {
                        tasks.add(new Task(getMower(taskInput.get(0)),getOrders(taskInput.get(1))));
                    } catch (MowerIllegalArgumentException e) {
                        throw new RuntimeException(e);
                    } catch (InvalidOrderException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            tasksPerLawn.put(lawn,tasks);
        }
    }

    public static Lawn getLawn(String input) {
        if (isValidLawnInput(input)) {
            String[] split = input.split(DELIMITER_SPACE);
            return new Lawn(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
        } else {
            throw new LawnIllegalArgumentException("Lawn argument %s is not valid !", input);
        }
    }

    private static boolean isValidLawnInput(String input) {
        if (StringUtils.isBlank(input)) {
            return false;
        }
        String[] split = input.split(DELIMITER_SPACE);
        return split.length == 2 &&
                split[0].matches(REGEX_NUM) &&
                split[1].matches(REGEX_NUM);

    }

    public static Mower getMower(String input) throws MowerIllegalArgumentException {
        if (isValidMowerInput(input)) {
            String[] split = input.split(DELIMITER_SPACE);
            return Mower.builder()
                    .position(new Position(split[0], split[1]))
                    .orientation(OrientationEnum.valueOf(split[2]))
                    .build();
        } else {
            throw new MowerIllegalArgumentException("Mower argument %s is not valid !", input);
        }
    }

    private static boolean isValidMowerInput(String mowerInput) {
        if (StringUtils.isBlank(mowerInput)) {
            return false;
        }
        String[] split = mowerInput.split(DELIMITER_SPACE);
        return split.length == 3 &&
                split[0].matches(REGEX_NUM) &&
                split[1].matches(REGEX_NUM) &&
                PATTERN_ORIENTATION.matcher(split[2]).find();
    }

    public static List<OrderEnum> getOrders(String ordersInput) throws InvalidOrderException {
        if(isValidOrdersInput(ordersInput)){
            return Arrays.stream(ordersInput.split("")).map(OrderEnum::fromString).toList();
        }else{
            throw new InvalidOrderException("Orders argument %s are not valid !", ordersInput);
        }
    }

    private static boolean isValidOrdersInput(String ordersInput) {
        return PATTERN_MOVE.matcher(ordersInput).find();
    }

}
