package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public WebDriver driver;

    private final int BASIC_TIME = 15;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElementByXpath(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(BASIC_TIME));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        return driver.findElement(By.xpath(locator));
    }

    public void clickElementByXpath(WebElement getElementByXpath) {
        getElementByXpath.click();
    }

    public List<WebElement> getElementsByXpath(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(BASIC_TIME));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        return driver.findElements(By.xpath(locator));
    }

    public boolean retryingClickStale(String locator) { //method for Task1
        int tryCount = 0;
        boolean res = false;

        while(tryCount < 2) {
            try {
                getElementByXpath(locator).click();
                res = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            tryCount++;
        }
        return res;
    }
}
