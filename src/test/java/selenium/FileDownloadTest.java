package selenium;

import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class FileDownloadTest extends BaseTest {
    private static final long MAX_WAIT = 10;
    String userDir = System.getProperty("user.dir") + "\\";
    private final By FILE_DOWNLOAD = By.xpath(String.format(PRECISE_TEXT_XPATH, "File Download"));
    private final String FILE_NAME = "test-file.txt";
    private final By FILE_NAME_XPATH = By.xpath(String.format(PRECISE_TEXT_XPATH, FILE_NAME));
    private final String FILE_PATH = userDir + RELATIVE_RESOURCE_PATH + FILE_NAME;
    private final File downloadedFile = new File(FILE_PATH);

    //BeforeMethod Annotation should be commented on BaseTest.java file
    @BeforeMethod
    public void initializeChrome(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", (userDir + RELATIVE_RESOURCE_PATH));
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Test
    public void fileUploadTest() {
        driver.findElement(FILE_DOWNLOAD).click();
        Assert.assertTrue(driver.findElement(FILE_NAME_XPATH).isDisplayed(), "File is not displayed");
        driver.findElement(FILE_NAME_XPATH).click();
        // todo: assert file is downloaded
        Assert.assertTrue(isFileExists(downloadedFile), "File is not downloaded");
    }

    private boolean isFileExists(File file){
        try{
            Awaitility.await().atMost(MAX_WAIT, TimeUnit.SECONDS).until(file::exists);
        } catch (ConditionTimeoutException exception){
            return false;
        }
        return true;
    }

    // todo: delete file
    @AfterMethod
    public void deleteFile(){
        if (downloadedFile.exists()){
            downloadedFile.delete();
        }
    }
}
