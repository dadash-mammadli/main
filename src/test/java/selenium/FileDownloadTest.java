package selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FileDownloadTest extends BaseTest {
    private final By FILE_DOWNLOAD = By.xpath(String.format(PRECISE_TEXT_XPATH, "File Download"));
    private final String FILE_NAME = "Test.txt";
    private final By FILE_NAME_XPATH = By.xpath(String.format(PRECISE_TEXT_XPATH, FILE_NAME));


    @Test
    public void fileUploadTest() {
        driver.findElement(FILE_DOWNLOAD).click();
        Assert.assertTrue(driver.findElement(FILE_NAME_XPATH).isDisplayed(), "File is not displayed");
        driver.findElement(FILE_NAME_XPATH).click();
        // todo: assert file is downloaded
    }

    // todo: delete file
}
