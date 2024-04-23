package com.moweritnow.ports.in;

import com.moweritnow.model.Lawn;
import com.moweritnow.model.Task;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Queue;

public interface ITaskBuilder {
    Map<Lawn, Queue<Task>> getTasks();

    void loadTasks(String s) throws IOException, URISyntaxException;
}
