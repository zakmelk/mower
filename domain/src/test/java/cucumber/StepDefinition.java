package cucumber;

import com.moweritnow.model.InvalidOrderException;
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
        try {
            orderEnum = OrderEnum.fromChar(string.charAt(0));
        } catch (InvalidOrderException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("fromChar should return OrderEnum.A")
    public void fromCharReturnA(){
        assertEquals(OrderEnum.A,orderEnum);
    }
}
