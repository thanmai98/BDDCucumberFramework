package StepDefinition;

import Pages.Global;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
