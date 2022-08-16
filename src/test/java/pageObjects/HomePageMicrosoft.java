package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageMicrosoft extends BasePage {

    private final int FACEBOOK_INDEX = 0;
    private final int YOUTUBE_INDEX = 1;

    public HomePageMicrosoft(WebDriver driver) {
        super(driver);
    }

    public WebElement getMicrosoftLogo() {
        return getElementByXpath("//img[@itemprop='logo']");
    }

    public WebElement getFacebookBtn() {
        return getElementsByXpath("//a[@itemprop='sameAs']").get(FACEBOOK_INDEX);
    }

    public void clickFacebookBtn() {
        clickElementByXpath(getFacebookBtn());
    }
}
