package cucumber;

import com.moweritnow.model.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinition {

    private Lawn lawn;

    private Task task;

    @Given("input {string}")
    public void inputConfig(String input) {
        String[] split = input.split(" ");
        lawn = new Lawn(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        Position position = new Position(split[2], split[3]);
        Mower mower = new Mower(position, OrientationEnum.fromString(split[4]));
        List<OrderEnum> orders = Arrays.stream(split[5].split("")).map(OrderEnum::fromString).toList();
        task = new Task(mower, orders);
    }

    @When("call task launch order")
    public void callTaskLaunchOrder() {
        task.executeOrders(lawn);
    }

    @Then("output should be {string}")
    public void outputShouldBe(String output) {
        assertEquals(output, task.getMower().toString());
    }
}
