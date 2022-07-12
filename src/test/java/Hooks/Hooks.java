package Hooks;

import Pages.Global;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks extends Global {

    @AfterStep
    public void attachScreenshot(Scenario scenario) throws IOException {
        scenario.attach(getByteScreenshot(),"image/png","Screenshot");
    }
}
