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


    @Test
    public void iFrameTest() {
        driver.findElement(FRAMES).click();
        driver.findElement(IFRAME).click();
        //todo: input text to the text field
        Assert.assertTrue(driver.findElement(By.xpath(String.format(PRECISE_TEXT_XPATH, INIT_TEXT + RANDOM))).isDisplayed(),
                TEXT_IS_NOT_DISPLAYED_MSG);
        driver.findElement(EDIT).click();
        driver.findElement(UNDO).click();
        // todo: assert text is not displayed
    }
}
