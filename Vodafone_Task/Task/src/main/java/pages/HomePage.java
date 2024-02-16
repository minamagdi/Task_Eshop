package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By menuTabs(String tabName) {
        String xpathExpression = String.format("//div[@class='menu-tabs']/button[contains(text(), '%s')]", tabName);
        return By.xpath(xpathExpression);
    }

    private final By vodafoneIcon = By.cssSelector("div.logo");

    public void clickOnMenuTab(String tabName) {
        driver.findElement(menuTabs(tabName)).click();
    }

    public Boolean assertVodafoneLogoIsExist() {
        return driver.findElement(vodafoneIcon).isDisplayed();
    }
}