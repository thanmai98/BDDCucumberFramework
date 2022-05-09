package StepDefinition;

import Pages.Global;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class CommonStepDef extends Global{

    @Given("User launches required {string}")
    public void launchRequiredBrowser(String browser) {
        launchBrowser(browser);
    }

    @Then("User should navigate to PHPTravels site")
    public void openPHPTravelSite() throws IOException {
        openUrl();
    }
}
