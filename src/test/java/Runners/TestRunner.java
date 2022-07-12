package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/FeatureFiles",
        tags = "@test",
        glue = {"StepDefinition","Hooks"},
        plugin = {"pretty", "summary",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        publish = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
//    @Override
//    @DataProvider(parallel = false)
//    public Object[][] scenarios{
//        return super.scenarios();
//    }
}
