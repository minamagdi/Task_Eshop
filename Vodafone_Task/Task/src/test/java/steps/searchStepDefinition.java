package steps;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigUtils;

import java.time.Duration;


public class searchStepDefinition extends BaseTest {
    @Given("User navigate to the url")
    public void user_navigate_to_the_url() {
        open();
    }

    @Then("User Assert that he has landed on the main page")
    public void user_assert_that_he_has_landed_on_the_main_page() {
        Assert.assertTrue(homePage.assertVodafoneLogoIsExist());
    }

    @When("User navigate to {string} section")
    public void user_navigate_to_smart_phone_section(String type) {
        homePage.clickOnMenuTab(type);
    }

    @And("User search in {string} section for {string}")
    public void user_search_in_apple_section(String category, String deviceName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-cards")));
        categoriesPage.clickOnMenuTab(category);
        Thread.sleep(20000);
        categoriesPage.typeTextOnSearch(deviceName);
    }

    @Then("User validate result obtained")
    public void user_validate_result_obtained() {
        String deviceName = ConfigUtils.readDataFromPropertyFile().getProperty("deviceName");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-cards")));
        Assert.assertEquals("Device name not found",deviceName,categoriesPage.getIphoneText());
        driver.quit();
    }
}
