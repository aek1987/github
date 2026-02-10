package stepdefinitions;

import com.example.Calculator;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class AddSteps {

    private int a;
    private int b;
    private int result;

    @Given("two numbers {int} and {int}")
    public void two_numbers(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @When("I add the numbers")
    public void i_add_the_numbers() {
        Calculator calculator = new Calculator();
        result = calculator.add(a, b);
    }

    @Then("the result should be {int}")
    public void the_result_should_be(int expected) {
        assertEquals(expected, result);
    }
}
