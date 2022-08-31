package Pages;

import ExcelReader.Xls_Reader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Global {

    public static WebDriver driver;
    public static Properties prop = new Properties();

    Xls_Reader reader = new Xls_Reader("src/main/resources/Articles.xlsx");

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
        if(browserType.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
//            driver.get("https://www.phptravels.net");
        }

        String sheetName = "SLSQ";
        int rowCount = reader.getRowCount(sheetName);
        System.out.println(">>>>"+reader.getCellData(sheetName,"Article Id's",rowCount));
    }

    //To Launch the url in specific browser
    public void openUrl() throws IOException {
        driver.get(getConfig("url"));
    }

    public void clickButton(String buttonType) throws IOException {
        driver.findElement(By.xpath(getWebElement(buttonType))).click();
    }

    public byte[] getByteScreenshot() throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        return fileContent;
    }

    public void switchTabs(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        // change focus to new tab
        driver.switchTo().window(tabs.get(1));
    }
}
