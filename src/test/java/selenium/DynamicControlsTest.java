package selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {
    private final By DYNAMIC_CONTROL = By.xpath(String.format(PRECISE_TEXT_XPATH, "Dynamic Controls"));
    private final By ENABLE = By.xpath(String.format(PRECISE_TEXT_XPATH, "Enable"));

    @Test
    public void dynamicControlsTest() {
        driver.findElement(DYNAMIC_CONTROL).click();
        driver.findElement(ENABLE).click();
        // todo: assert input is enabled
        // todo: input random generated text
        // todo: assert inputted text
    }
}
