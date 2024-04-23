package com.moweritnow.out.cucumber;

import com.moweritnow.in.TaskBuilderFileAdapter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinition {
    private TaskBuilderFileAdapter taskBuilderFileAdapter;
    private String fileName;

    @Given("TaskBuilderFileAdapter")
    public void taskbuilderfileadapter() {
        taskBuilderFileAdapter = new TaskBuilderFileAdapter();
    }

    @When("call load tasks for {string}")
    public void callLoadTasksForInputTxt(String fileName) {
        taskBuilderFileAdapter.loadTasks(fileName);
    }

    @Then("tasks should have {string} task")
    public void tasksShouldHaveTask(String taskSize) {
        assertEquals(Integer.parseInt(taskSize), taskBuilderFileAdapter.getTasks().size());
    }
}
