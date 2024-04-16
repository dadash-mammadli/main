package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DataTableTests extends BaseTest {
    private final By SORTABLE_DATA_TABLES = By.xpath(String.format(PRECISE_TEXT_XPATH, "Sortable Data Tables"));
    private final By DUE_ELEMENTS_LOCATOR = By.xpath("//*[@id='table1']//td[4]");
    private final Double EXPECTED_SUM = 251.0;
    private final String CURRENCY_REGEX = "[^\\d.]";

    @Test
    public void dataTableTest() {
        driver.findElement(SORTABLE_DATA_TABLES).click();
        List<WebElement> dueList = driver.findElements(DUE_ELEMENTS_LOCATOR);
        Double actualSum = 0.0;
        for (WebElement element: dueList){
            String elementText = element.getText();
            actualSum += Double.parseDouble(elementText.replaceAll(CURRENCY_REGEX, ""));
        }
        Assert.assertEquals(actualSum, EXPECTED_SUM, "Sum is not correct");
        // todo: assert due sum
    }
}
