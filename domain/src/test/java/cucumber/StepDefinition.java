package cucumber;

import com.moweritnow.model.OrderEnum;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinition {

    private OrderEnum orderEnum;

    @Given("toto")
    public void toto(){}
    @When("call OrderEnum.fromChar with character {string}")
    public void call_order_enum_from_char_with_character(String string) {

    }
    @Then("fromChar should return OrderEnum.A")
    public void fromCharReturnA(){
        assertEquals(OrderEnum.A,orderEnum);
    }
}
