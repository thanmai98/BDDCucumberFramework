package StepDefinition;

import Pages.Global;
import io.cucumber.java.en.And;

import java.io.IOException;

public class HomeStepDef extends Global {

    @And("User clicks on signup button")
    public void clickSignupButton() throws IOException {
        clickButton("Signup");
    }
}
