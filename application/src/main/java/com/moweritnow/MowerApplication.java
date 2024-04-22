package com.moweritnow;

import com.moweritnow.in.TaskBuilderFileAdapter;
import com.moweritnow.out.ConsoleMowerDisplay;
import com.moweritnow.ports.out.IMowerDisplay;
import com.moweritnow.ports.in.ITaskBuilder;
import com.moweritnow.service.MowerService;

import java.io.IOException;
import java.net.URISyntaxException;

public class MowerApplication {
    public static void main(String[] args) throws IOException, URISyntaxException {
        // 1. Instantiate input adapter
        ITaskBuilder taskBuilderFileAdapter = new TaskBuilderFileAdapter();
        taskBuilderFileAdapter.loadTasks("input-1.txt");
        // 2. Instantiate hexagon
        MowerService mowerService = new MowerService(taskBuilderFileAdapter);
        // 3. Instantiate output adapter
        IMowerDisplay mowerDisplay = new ConsoleMowerDisplay();
        // 4. launch business logic
        mowerService.launch(mowerDisplay);
    }
}