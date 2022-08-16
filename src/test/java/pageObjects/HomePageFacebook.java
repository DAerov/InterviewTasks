package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageFacebook extends BasePage {

    public HomePageFacebook(WebDriver driver) {
        super(driver);
    }

    public WebElement getAccountName() {
        return getElementByXpath("//h1[@class='gmql0nx0 l94mrbxd p1ri9a11 lzcic4wl']");
    }
}
