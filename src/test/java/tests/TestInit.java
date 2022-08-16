package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

public class TestInit {

    public WebDriver driver;

    public void openUrl(String site) {
        driver.get(site);
    }

    public List<String> getTabs() { //get list of tabs in String
        return new ArrayList<>(driver.getWindowHandles());
    }

    public void switchTabs(String tab) { //switch to selected tab
        driver.switchTo().window(tab);
    }

    @BeforeMethod(onlyForGroups = "UI")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(onlyForGroups = "UI")
    public void after() {
        driver.quit();
    }
}
