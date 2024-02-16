package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CategoriesPage;
import pages.HomePage;
import utils.ConfigUtils;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected static HomePage homePage;
    protected static CategoriesPage categoriesPage;

    public static void open() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get(ConfigUtils.readDataFromPropertyFile().getProperty("baseUrl"));
        driver.findElement(By.cssSelector("button[aria-label='Close']")).click();
        homePage = new HomePage(driver);
        categoriesPage = new CategoriesPage(driver);
    }
}
