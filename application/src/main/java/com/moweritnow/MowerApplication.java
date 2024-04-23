package com.moweritnow;

import com.moweritnow.in.TaskBuilderFileAdapter;
import com.moweritnow.out.ConsoleMowerDisplay;
import com.moweritnow.ports.in.ITaskBuilder;
import com.moweritnow.ports.out.IMowerDisplay;
import com.moweritnow.service.MowerService;

import java.io.IOException;
import java.net.URISyntaxException;

public class MowerApplication {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String fileName = "input-1.txt";
        ITaskBuilder taskBuilderFileAdapter = getInputFileAdapter(fileName);
        MowerService mowerService = getHexagon(taskBuilderFileAdapter);
        IMowerDisplay mowerDisplay = getOutputDisplayAdapter();
        mowerService.launch(mowerDisplay);
    }

    private static IMowerDisplay getOutputDisplayAdapter() {
        IMowerDisplay mowerDisplay = new ConsoleMowerDisplay();
        return mowerDisplay;
    }

    private static MowerService getHexagon(ITaskBuilder taskBuilderFileAdapter) {
        MowerService mowerService = new MowerService(taskBuilderFileAdapter);
        return mowerService;
    }

    private static ITaskBuilder getInputFileAdapter(String fileName) throws IOException, URISyntaxException {
        ITaskBuilder taskBuilderFileAdapter = new TaskBuilderFileAdapter();
        taskBuilderFileAdapter.loadTasks(fileName);
        return taskBuilderFileAdapter;
    }
}