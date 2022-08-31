package StepDefinition;

import Pages.Global;
import io.cucumber.java.en.And;
import org.testng.Assert;

import java.io.IOException;

public class HomeStepDef extends Global {

    @And("User clicks on signup button")
    public void clickSignupButton() throws IOException {
        clickButton("Signup");
        switchTabs();
        String registerURL = driver.getCurrentUrl();
        Assert.assertEquals(registerURL,"https://phptravels.org/register.php");
    }
}
