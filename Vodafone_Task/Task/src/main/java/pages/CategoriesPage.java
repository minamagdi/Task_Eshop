package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriesPage extends BasePage{
    public CategoriesPage(WebDriver driver) {
        super(driver);
    }
    private By menuTabs(String tabName) {
        String xpathExpression = String.format("//div[contains(text(),'%s')]", tabName);
        return By.xpath(xpathExpression);
    }
    private final By search = By.cssSelector("input[placeholder='Search For ...']");
    private final By iphoneDevice = By.id("mainText");
    public void clickOnMenuTab(String tabName) {
        driver.findElement(menuTabs(tabName)).click();
    }

    public void typeTextOnSearch(String text) {
        driver.findElement(search).sendKeys(text);
    }

    public String getIphoneText() {
        return driver.findElement(iphoneDevice).getText();
    }

}
