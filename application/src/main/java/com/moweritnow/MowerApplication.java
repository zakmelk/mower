package com.moweritnow;

import com.moweritnow.in.TaskBuilderFileAdapter;
import com.moweritnow.out.ConsoleMowerDisplay;
import com.moweritnow.ports.IMowerDisplay;
import com.moweritnow.ports.ITaskBuilder;
import com.moweritnow.service.TaskService;

import java.io.IOException;
import java.net.URISyntaxException;

public class MowerApplication {
    public static void main(String[] args) throws IOException, URISyntaxException {
        ITaskBuilder taskBuilderFileAdapter = new TaskBuilderFileAdapter();
        taskBuilderFileAdapter.loadTasks("input-1.txt");
        IMowerDisplay mowerDisplay = new ConsoleMowerDisplay();
        TaskService taskService = new TaskService(taskBuilderFileAdapter,mowerDisplay);
        taskService.launch();
    }
}