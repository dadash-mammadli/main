package selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {
    private final By BASIC_AUTH = By.xpath(String.format(PRECISE_TEXT_XPATH, "Basic Auth"));
    private final By SUCCESS_AUTH = By.xpath(String.format(PARTICULAR_TEXT_XPATH,
            "Congratulations! You must have the proper credentials"));

    //todo: add basic auth

    @Test
    public void basicAuthTest() {
        driver.findElement(BASIC_AUTH).click();
        Assert.assertTrue(driver.findElement(SUCCESS_AUTH).isDisplayed(), "Message is not displayed");
    }
}
