package selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class FramesTest extends BaseTest {
    private final By FRAMES = By.xpath(String.format(PRECISE_TEXT_XPATH, "Frames"));
    private final By IFRAME = By.xpath(String.format(PRECISE_TEXT_XPATH, "iFrame"));
    private final String RANDOM = UUID.randomUUID().toString();
    private final String INIT_TEXT = "Your content goes here.";
    private final By EDIT = By.xpath(String.format(PRECISE_TEXT_XPATH, "Edit"));
    private final By UNDO = By.xpath(String.format(PRECISE_TEXT_XPATH, "Undo"));
    private final String TEXT_IS_NOT_DISPLAYED_MSG = "Text is not displayed";
    private final String IFRAME_ID = "mce_0_ifr";
    private final By TEXT_FIELD = By.id("tinymce");

    @Test
    public void iFrameTest() {
        driver.findElement(FRAMES).click();
        driver.findElement(IFRAME).click();

        //todo: input text to the text field
        driver.switchTo().frame(IFRAME_ID);
        driver.findElement(TEXT_FIELD).sendKeys(RANDOM);
        Assert.assertTrue(driver.findElement(By.xpath(String.format(PRECISE_TEXT_XPATH, INIT_TEXT + RANDOM))).isDisplayed(),
                TEXT_IS_NOT_DISPLAYED_MSG);

        driver.switchTo().defaultContent();
        driver.findElement(EDIT).click();
        driver.findElement(UNDO).click();

        // todo: assert text is not displayed
        driver.switchTo().frame(IFRAME_ID);
        Assert.assertTrue(driver.findElement(By.xpath(String.format(PRECISE_TEXT_XPATH, INIT_TEXT))).isDisplayed(), TEXT_IS_NOT_DISPLAYED_MSG);
    }
}
