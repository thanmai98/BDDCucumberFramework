package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Global {

    public static WebDriver driver;
    public static Properties prop = new Properties();

    //To get the key values from Properties file
    public String getConfig(String key) throws IOException {
        File src = new File("src/test/Resources/Config.properties");
        FileInputStream fis = new FileInputStream(src);
        prop.load(fis);
        return prop.getProperty(key);
    }

    public String getWebElement(String key) throws IOException {
        File src = new File("src/test/Resources/ObjectRepo.properties");
        FileInputStream fis = new FileInputStream(src);
        prop.load(fis);
        return prop.getProperty(key);
    }

    //To Launch browser as per user requirement
    public void launchBrowser(String browserType){
        if(browserType.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    //To Launch the url in specific browser
    public void openUrl() throws IOException {
        driver.get(getConfig("url"));
    }

    public void clickButton(String buttonType) throws IOException {
        driver.findElement(By.xpath(getWebElement(buttonType))).click();
    }
}
